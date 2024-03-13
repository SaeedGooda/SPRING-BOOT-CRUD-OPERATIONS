package com.crud.springbootcrud.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Add New Student
    public void addNewStudent(Student student) {
        // The student email should be unique
        // check if email of student exists or not
        boolean exists = studentRepository.existsByEmail(student.getEmail());
        if(exists){
            throw new IllegalStateException("email already exist");
        }
        studentRepository.save(student);
    }

    // Get ALL Students
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    // Get Student using studentid
    public Student getStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with " + studentId + " doesn't exist");
        }
        return studentRepository.findById(studentId).get();
    }

    // Update student using studentid and data we want to update (name or email or both)
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isEmpty()){
            throw new IllegalStateException("student with " + studentId + " doesn't exist");
        }
        if(name != null &&
                !name.isEmpty() &&
                !Objects.equals(student.get().getName(), name)
        ){
            student.get().setName(name);
        }
        if(email != null &&
                !email.isEmpty() &&
                !Objects.equals(student.get().getEmail(), email)
        ){
            student.get().setName(email);
        }
    }

    // Delete Student using studentid
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with " + studentId + " doesn't exist");
        }
        studentRepository.deleteById(studentId);
    }
}

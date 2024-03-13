package com.crud.springbootcrud.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
    final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE NEW STUDENT
    @PostMapping
    public void addNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    // READ ALL STUDENTS ( GET ALL STUDENTS )
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    // READ STUDENT ( GET STUDENT )
    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Long studentId){
        return studentService.getStudent(studentId);
    }

    // UPDATE STUDENT
    @PutMapping(path = "/{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        studentService.updateStudent(studentId, name, email);
    }

    // DELETE STUDENT
    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

}

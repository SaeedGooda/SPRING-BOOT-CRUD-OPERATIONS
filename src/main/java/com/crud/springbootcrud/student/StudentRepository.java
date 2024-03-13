package com.crud.springbootcrud.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Function that check if email exists or not
    public boolean existsByEmail(String email);
}

package com.crud.springbootcrud.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {
    // Function that use StudentRepository to add new Students to database
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student saeed = new Student(
                    "Saeed",
                    "saeedgooda219@gmail.com",
                    23
            );
            Student ahmed = new Student(
                    "Ahmed",
                    "ahmed@gmail.com",
                    20
            );
            repository.saveAll(List.of(saeed, ahmed));
        };
    }
}

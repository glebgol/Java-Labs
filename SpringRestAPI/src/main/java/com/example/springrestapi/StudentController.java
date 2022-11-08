package com.example.springrestapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private final IStudentRepository repository;

    public StudentController(IStudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/students")
    List<Student> getAllStudents() {
        return repository.findAll();
    }
}

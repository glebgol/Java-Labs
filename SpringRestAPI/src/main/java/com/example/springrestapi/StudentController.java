package com.example.springrestapi;

import org.springframework.http.HttpMessage;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private final IStudentRepository repository;

    public StudentController(IStudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Student> getAllStudents() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    Student getStudentById(@PathVariable Long id) {
        return repository.findById(id).get();
    }
}

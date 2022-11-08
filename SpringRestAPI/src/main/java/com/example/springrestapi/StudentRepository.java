package com.example.springrestapi;

import interfaces.IStudentRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StudentRepository implements IStudentRepository {
    private List<Student> students;

    public StudentRepository() {
        this.students = Arrays.asList(new Student("Ivan", 16), new Student("Петя", 18));
    }

    @Override
    public Iterable<Student> findAll() {
        return students;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void createStudent(Student student) {

    }
}

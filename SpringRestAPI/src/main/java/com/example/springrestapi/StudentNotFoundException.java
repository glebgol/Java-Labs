package com.example.springrestapi;


class StudentNotFoundException extends RuntimeException {

    StudentNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}

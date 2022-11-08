package com.example.springrestapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

    private @Id @GeneratedValue Long id;
    private String name;
    private int age;
    public void setId(Long id) {
        this.id = id;
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

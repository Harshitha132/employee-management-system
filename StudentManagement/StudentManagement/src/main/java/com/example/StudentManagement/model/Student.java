package com.example.StudentManagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String course;
    @Column(name = "student_group")
    private String student_group;
    private int age;
    // Constructors
    public Student() {}

    public Student(String name, String email, String course, String student_group, int age) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.student_group = student_group;
        this.age  = age;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    public String getGroup() {
        return student_group;
    }

    public void setGroup(String student_group) {
        this.student_group = student_group;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
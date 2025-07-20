package com.example.StudentManagement.controller;

import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository sr;

    // 1. Show all students
    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", sr.findAll());
        return "students-list";  // students-list.html
    }

    // 2. Show add student form
    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";  // add-student.html
    }

    // 3. Handle new student submission
    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student) {
        sr.save(student);
        return "redirect:/students";
    }

    // 4. Show update form
    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable("id") Long id, Model model) {
        Student s = sr.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));
        model.addAttribute("student", s);
        return "update-student"; // update_student.html
    }

    // 5. Handle update submission
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        student.setId(id);  // important to ensure correct update
        sr.save(student);
        return "redirect:/students";
    }

    // 6. Delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        sr.deleteById(id);
        return "redirect:/students";
    }
}
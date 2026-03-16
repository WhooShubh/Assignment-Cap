package com.capg.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class DemoController {

    @Autowired
    private StudentRepo repo;

    // Save Student
    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
        return repo.save(student);
    }

    // Get All Students
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return repo.findAll();
    }
}

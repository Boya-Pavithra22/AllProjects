package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.wipro.model.Student;
import com.wipro.service.StudentService;


@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/add")
    @ResponseBody
    public String addStudent() {
        Student s = new Student();
        s.setName("Test User");
        s.setEmail("test@example.com");
        studentService.save(s);
        return "Student added!";
    }
}

package com.wipro.springboot.controller;

import com.wipro.springboot.model.User;
import com.wipro.springboot.repository.UserRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Question 3 

@RestController
@RequestMapping("/api/register")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/adduser")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok("User registered successfully with ID: " + savedUser);
    }
}

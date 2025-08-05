package com.wipro.springboot.controller;

import com.wipro.springboot.model.RegistrationUser;
import com.wipro.springboot.repository.RegistrationUserRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Question 3 

@RestController
@RequestMapping("/api/register")
public class RegistrationController {

    @Autowired
    private RegistrationUserRepository registrationUserRepository;

    @PostMapping("/addregistrationuser")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationUser user) {
        RegistrationUser savedUser = registrationUserRepository.save(user);
        return ResponseEntity.ok("RegistrationUser registered successfully with ID: " + savedUser);
    }
}

package com.wipro.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.springboot.component.ClassKLM;

//Question 1

@RestController
@RequestMapping("/qualifier")
public class QualifierTestAppController {
	
	

    @Autowired(required = true)
    private ClassKLM klm;

    @GetMapping
    public String testQualifierInjection() {
    	klm.execute();
        return "Check console for output!";
    }
}


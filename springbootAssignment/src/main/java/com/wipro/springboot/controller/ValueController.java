package com.wipro.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.springboot.component.ValueReader;

//Question2 

@RestController
@RequestMapping("/values")
public class ValueController {

    @Autowired
    private ValueReader valueReader;

    @GetMapping
    public String getValues() {
        return "Integer: " + valueReader.getValueInteger() +
               ", Decimal: " + valueReader.getValueDouble() +
               ", Boolean: " + valueReader.getValueBoolean();
    }
}

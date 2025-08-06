package com.wipro.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/redirect/test")
    public String redirectToTest2() {
        return "success";
    }
}

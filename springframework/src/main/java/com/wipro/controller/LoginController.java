package com.wipro.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.wipro.component.*;

@ComponentScan("com.wipro.component")
public class LoginController {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LoginController.class);

        PropertyLoader loader = context.getBean(PropertyLoader.class);

        System.out.println("URL      : " + loader.getUrl());
        System.out.println("Username : " + loader.getUsername());
        System.out.println("Password : " + loader.getPassword());

        context.close();
    }
}

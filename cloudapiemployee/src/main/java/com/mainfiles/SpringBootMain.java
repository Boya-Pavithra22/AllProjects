package com.mainfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//employee
@SpringBootApplication
@ComponentScan(basePackages = "com")
public class SpringBootMain {

	public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
    }
}

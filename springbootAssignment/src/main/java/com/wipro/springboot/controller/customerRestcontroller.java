package com.wipro.springboot.controller;


       import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.wipro.springboot.model.*;

import java.util.Arrays;
	import java.util.List;

	@RestController
	@RequestMapping("/api/customer")
	public class customerRestcontroller {

	    @GetMapping("/getall")
	    public List<customer> getAllCustomers() {
	        return Arrays.asList(
	            new customer(101, "John", "Doe", "johnd@gmail.com", "123-123-3453", 1467200323609L),
	            new customer(102, "Russ", "Smith", "russ@gmail.com", "343-545-2455", 1467200323609L),
	            new customer(301, "Katie", "Williams", "kwilliams@gmail.com", "876-327-9987", 1467200323609L)
	        );
	    }
	}



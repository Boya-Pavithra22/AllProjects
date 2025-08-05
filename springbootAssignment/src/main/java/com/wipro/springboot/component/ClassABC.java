package com.wipro.springboot.component;

import org.springframework.stereotype.Component;

import com.wipro.springboot.service.InterfacePQR;

@Component("classABC")
public class ClassABC implements InterfacePQR{
	 public void display() {
	        System.out.println("Hi... I am ClassABC");
	    }
}

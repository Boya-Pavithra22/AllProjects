package com.wipro.springboot.component;


import org.springframework.stereotype.Component;

import com.wipro.springboot.service.*;

@Component("classXYZ")
public class ClassXYZ implements InterfacePQR{
	public void display() {
        System.out.println("Hi... I am ClassXYZ");
    }
}

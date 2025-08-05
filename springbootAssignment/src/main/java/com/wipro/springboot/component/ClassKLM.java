package com.wipro.springboot.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.wipro.springboot.service.*;

@Component
public class ClassKLM {
	@Autowired
    @Qualifier("classABC")  
    InterfacePQR pqr;
	
	public void execute() {
        pqr.display();
    }

}

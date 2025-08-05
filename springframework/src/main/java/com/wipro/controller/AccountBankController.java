package com.wipro.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.wipro.model.*;

public class AccountBankController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("accountBankContext.xml");

        AccountBank account = (AccountBank) context.getBean("accountBean");
        account.printDetails();
    }
}

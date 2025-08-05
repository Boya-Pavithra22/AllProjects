package com.wipro.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;
import com.wipro.model.*;

public class AccountTypeController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("accountType.xml");

        AccountType account = (AccountType) context.getBean("account");

        Scanner sc = new Scanner(System.in);

        System.out.println("Default account loaded from properties:");
        account.display();

        System.out.println("Do you want to override the values? (yes/no)");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter Account Number: ");
            account.setNumber(Integer.parseInt(sc.nextLine()));

            System.out.print("Enter Account Holder Name: ");
            account.setHolder(sc.nextLine());

            System.out.print("Enter Account Balance: ");
            account.setBalance(Double.parseDouble(sc.nextLine()));

            System.out.print("Enter Account Type: ");
            account.setType(sc.nextLine());
        }

        System.out.println("Final Account Details:");
        account.display();
    }
}

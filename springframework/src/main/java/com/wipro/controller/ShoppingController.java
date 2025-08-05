package com.wipro.controller;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.wipro.service.*;

public class ShoppingController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("shoppingContext.xml");
        ShoppingService shop = (ShoppingService) context.getBean("shop");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter item name: ");
        String item = sc.nextLine();

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        shop.purchaseItems(item, qty);
    }
}

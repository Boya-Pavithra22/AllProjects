package com.wipro.service;

public class ShoppingService {
    private String name;
    private String category;

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void purchaseItems(String itemName, int quantity) {
        System.out.println("Welcome to " + name + " - Category: " + category);
        System.out.println("✅ Purchased " + quantity + " unit(s) of '" + itemName + "'. Thank you for shopping!");
    }
}

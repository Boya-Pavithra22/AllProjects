package com.wipro.hibernateassignment;

import java.util.List;
import java.util.Scanner;

import com.wipro.dao.ItemDAO;
import com.wipro.model.Item;

public class ItemOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemDAO dao = new ItemDAO();

        while (true) {
            System.out.println("\nHIBERNATE:");
            System.out.println("1. Add");
            System.out.println("2. View All");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Get by ID");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    dao.addItem(new Item(name, price));
                    break;
                case 2:
                    List<Item> items = dao.getAllItems();
                    items.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();
                    Item existing = dao.getItemById(id);
                    if (existing != null) {
                        System.out.print("Enter new name: ");
                        existing.setName(sc.next());
                        System.out.print("Enter new price: ");
                        existing.setPrice(sc.nextDouble());
                        dao.updateItem(existing);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    dao.deleteItem(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter ID: ");
                    Item item = dao.getItemById(sc.nextInt());
                    System.out.println(item != null ? item : "Item not found.");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

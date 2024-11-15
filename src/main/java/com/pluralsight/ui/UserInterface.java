package com.pluralsight.ui;

import com.pluralsight.order.Order;

import java.util.Scanner;

public class UserInterface {
    private Order order;
    private Scanner scanner;
    private String customerName;

    public UserInterface(Order order) {
        this.order = order;
        this.scanner = new Scanner(System.in);
    }

    // Start the interface with customer greeting
    public void startInterface() {
        System.out.print("Welcome to Stan Mikita's Subs! What's your name? ");
        customerName = scanner.nextLine();
        System.out.println("Nice to meet you, " + customerName + "! Let's get started.");
        homeScreen();
    }

    public void orderScreen() {
        // Allow the user to start an order
        System.out.println("Start your order here.");
        // Implement the logic for selecting items
    }

    public void addSandwichScreen() {
        // Allow user to customize and add a sandwich
        System.out.println("Add a sandwich to your order.");
        // Logic for adding sandwich
    }

    public void addDrinkScreen() {
        // Allow user to select a drink
        System.out.println("Add a drink to your order.");
        // Logic for adding drink
    }

    public void addChipScreen() {
        // Allow user to select chips
        System.out.println("Add chips to your order.");
        // Logic for adding chips
    }

    public void checkoutScreen() {
        // Show final order and checkout
        System.out.println("Your final order is: " + order.toString());
        order.checkout();
    }
}


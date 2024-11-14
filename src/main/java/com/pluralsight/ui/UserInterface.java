package com.pluralsight.ui;

import com.pluralsight.order.Order;

import java.util.Scanner;

public class UserInterface {
    private Order order;
    private Scanner scanner;

    public UserInterface(Order order) {
        this.order = order;
        this.scanner = new Scanner(System.in);
    }

    public void homeScreen() {
        // Display main menu
        System.out.println("Welcome to the Sandwich Shop!");
        // Show menu options
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


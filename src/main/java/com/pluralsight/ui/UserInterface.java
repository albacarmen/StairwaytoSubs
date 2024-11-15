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
    public void homeScreen() {
        greetCustomer();

        boolean running = true;
        while (running) {
            displayHomeMenu();
            int choice = getUserInput();

            switch (choice) {
                case 1:
                    startNewOrder();
                    break;
                case 0:
                    exitApplication();
                    running = false;
                    break;
                default:
                    invalidChoiceMessage();
            }
        }
    }

    private void greetCustomer() {
        System.out.println("Welcome to Stan Mikita's Subs – Party on, dude!");
        System.out.print("What's your name? ");
        customerName = scanner.nextLine();
    }

    private void displayHomeMenu() {
        System.out.println("\n1) New Order");
        System.out.println("0) Exit");
        System.out.print("Select an option: ");
    }

    private int getUserInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        return input;
    }

    private void startNewOrder() {
        this.order = new Order();
        orderScreen(); // Navigate to the order screen
    }

    private void exitApplication() {
        System.out.println("Party On, " + customerName + "!");
    }

    private void invalidChoiceMessage() {
        System.out.println("Invalid choice. Try again!");
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


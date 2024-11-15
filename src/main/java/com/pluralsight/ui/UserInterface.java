package com.pluralsight.ui;

import com.pluralsight.order.Order;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    private Order order;
    private Scanner scanner;
    private String customerName;

    public UserInterface(Order order) {
        this.order = order;
        this.scanner = new Scanner(System.in);
    }

    // customer greeting


    public void homeScreen() {
        greetCustomer();

        Map<Integer, Runnable> actions = new HashMap<>();
        actions.put(1, this::startNewOrder);
        actions.put(0, this::exitApplication);

        boolean running = true;
        while (running) {
            displayHomeMenu();
            int choice = getUserInput();

            Runnable action = actions.get(choice);
            if (action != null) {
                action.run();
                if (choice == 0) running = false; // Stop loop if exiting
            } else {
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
        System.out.println("\nWelcome back, " + customerName + "! Start your order here.");

        Map<Integer, Runnable> actions = new HashMap<>();
        actions.put(1, this::addSandwichScreen);
        actions.put(2, this::addDrinkScreen);
        actions.put(3, this::addChipScreen);
        actions.put(4, this::checkoutScreen);
        actions.put(0, this::cancelOrder);

        boolean ordering = true;
        while (ordering) {
            displayOrderMenu();
            int choice = getUserInput();

            Runnable action = actions.get(choice);
            if (action != null) {
                action.run();
                if (choice == 4 || choice == 0) ordering = false; // End if checkout or cancel
            } else {
                invalidChoiceMessage();
            }
        }
    }

    private void displayOrderMenu() {
        System.out.println("\nOrder Menu:");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order - Go back to home screen");
        System.out.print("Select an option: ");
    }

    private void cancelOrder() {
        this.order = null; // Clear current order
        System.out.println("Order canceled. Returning to the home screen.");
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


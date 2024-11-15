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

    public void orderScreen() {
        boolean continueOrder = true;

        while (continueOrder) {
            System.out.println("\nSTAN MIKITA'S ORDER SCREEN:");
            System.out.println("1. Build Your Epic Sandwich");
            System.out.println("2. Pick a Flavorful Drink");
            System.out.println("3. Add Crispy Chips");
            System.out.println("4. Checkout, already?");
            System.out.println("5. Cancel Your Order (Abort Mission)");
            System.out.print("What's your next move? ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    addSandwich();
                    System.out.println("Whoa, you're crafting a masterpiece with some awesome toppings!");
                }
                case 2 -> {
                    currentOrder.addDrink(chooseDrink());
                    System.out.println("Sweet! You picked a drink to wash down your sandwich. Nice choice.");
                }
                case 3 -> {
                    currentOrder.addChips(chooseChips());
                    System.out.println("Crunch time! Chips added to your order, bringing the crunch factor.");
                }
                case 4 -> {
                    checkoutScreen();
                    continueOrder = false;
                }
                case 5 -> {
                    cancelOrder();
                    continueOrder = false;
                }
                default -> System.out.println("Oops! Not a valid choice. Try again, dude!");
            }
        }
    }

    public void cancelOrder() {
        System.out.println("\nWhoa, looks like you're bailing on the order. Are you sure you want to cancel?");
        System.out.println("Your epic sandwich journey will end here, bro.");
        System.out.println("Party on! Order canceled.");
        // Optionally, reset or clear the current order if necessary
        currentOrder = null;  // Clear the order if needed
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


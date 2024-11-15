package com.pluralsight.ui;
import com.pluralsight.IPriceable.*;
import com.pluralsight.order.Order;
import com.pluralsight.order.OrderFileManager;
import com.pluralsight.sandwich.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserInterface {
    private Order order;
    private Scanner scanner;
    private String customerName;

    public UserInterface() {
        this.order = new Order();
        this.scanner = new Scanner(System.in);
        this.customerName = "";
    }

    public void homeScreen() {
        greetCustomer();

        var running = true;

        while (running) {
            System.out.println("\n1) New Order");
            System.out.println("0) Exit");
            System.out.print("Select an option: ");

            var choice = getUserInput();

            switch (choice) {
                case 0:
                    System.out.println("Party On, " + customerName + "!");
                    running = false;
                    break;

                case 1:
                    startNewOrder();
                    break;

                default:
                    invalidChoiceMessage();
                    break;
            }
        }
    }

    private void greetCustomer() {
        System.out.println("Welcome to Stan Mikita's Subs – Party on, dude!");
        System.out.print("What's your name? ");
        customerName = scanner.nextLine();
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
        displayOrderScreen(); // Navigate to the order screen
    }

    private void invalidChoiceMessage() {
        System.out.println("Invalid choice. Try again!");
    }

    public void displayOrderScreen() {
        var continueOrder = true;

        while (continueOrder) {
            System.out.println("\nSTAN MIKITA'S ORDER SCREEN:");
            System.out.println("1. Build an Epic Sandwich");
            System.out.println("2. Pick a Flavorful Drink");
            System.out.println("3. Add Crispy Chips");
            System.out.println("4. Checkout, already?");
            System.out.println("5. Cancel Your Order (Abort Mission)");
            System.out.print("What's your next move? ");

            var choice = getUserInput();  // Reusing the getUserInput method for consistency.

            switch (choice) {
                case 1:
                    addSandwich();
                    break;

                case 2:
                    addDrink();
                    break;

                case 3:
                    addChips();
                    break;

                case 4:
                    checkout();
                    continueOrder = false;
                    break;

                case 5:
                    cancelOrder();
                    continueOrder = false;
                    break;

                default:
                    invalidChoiceMessage();
                    break;
            }
        }
    }


    public void cancelOrder() {
        System.out.println("\nWhoa, looks like you're bailing on the order. Are you sure you want to cancel?");
        System.out.println("Your epic sandwich journey will end here, bro.");
        System.out.println("Party on! Order canceled.");
        // Optionally, reset or clear the current order if necessary
        order = null;  // Clear the order if needed
    }


    public void addSandwich() {
        System.out.println("\n** Add Your Sandwich **");
        System.out.println("1. Create a Custom Sandwich");
        System.out.println("2. Choose a Signature Sandwich");

        while (true) {
            System.out.print("Enter choice (1 or 2): ");

            var choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    addCustomSandwich();
                    break;

                case 2:
                    addSignatureSandwich();
                    break;

                default:
                    System.out.println("'" + choice + "' is not a valid choice!");
                    continue;
            }

            break;
        }
    }

    private void addCustomSandwich() {
        System.out.println("\n** Add Your Custom Sandwich **");

        // Select bread type
        var bread = chooseBread();

        // Select sandwich size
        var size = selectSize();

        // Add toppings (meats, cheeses, sauces, etc.)
        var meats = selectMeats();
        var cheeses = selectCheeses();
        var otherToppings = selectOtherToppings();
        var sauces = selectSauces();

        // Toasting option
        boolean isToasted = selectToasting();

        // Create the sandwich and add to the order
        var sandwich = new CustomSandwich(bread, size, meats, sauces, otherToppings, cheeses, isToasted);
        order.addItem(sandwich);  // Assuming addSandwich() is defined in the Order class

        System.out.println("\nSandwich added to your order!");
        System.out.println(sandwich);  // Display the sandwich details
    }

    private void addSignatureSandwich() {
        System.out.println("\nSelect your signature sandwich (premium):");
        System.out.println("1. Asian Delight");
        System.out.println("2. Latin Experience");
        System.out.println("3. Turbo Fusion Ultimax");

        var sandwich = (Sandwich)null;

        while (true) {
            System.out.print("Enter choice: ");

            var choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    sandwich = new AsianSandwich();
                    break;

                case 2:
                    sandwich = new LatinSandwich();
                    break;

                case 3:
                    sandwich = new FusionSandwich();
                    break;

                default:
                    System.out.println("'' is not a valid choice!");
                    continue;
            }

            break;
        }

        order.addItem(sandwich);
        System.out.println("Signature sandwich added!");
        System.out.println(sandwich);
    }

    private Bread chooseBread() {
        var type = selectOption(
                "Select Your Bread:",
                "Telera",
                "Bao",
                "Banh Mi",
                "Bolillo",
                "Arepa"
        );
        var bread = new Bread(type);

        return bread;
    }

    private int selectSize() {

        int size = 0;

        while (true) {
            var optionText = selectOption(
                    "Select Your Size:",
                    "Mini",
                    "Regular",
                    "Giant"
            );

            size = switch (optionText) {
                case "Mini" -> 1;
                case "Regular" -> 2;
                case "Giant" -> 3;
                default -> 0;
            };

            if (size != 0)
                break;

            System.out.println("'" + optionText + "' is not a valid size!");
        }

        return size;
    }

    private List<Meat> selectMeats() {
        var meatTexts = selectMultipleOptions(
                "Select Your Meats (you can select multiple):",
                "Carnitas",
                "Korean BBQ Beef",
                "Grilled Chicken with Chipotle",
                "Teriyaki Pork",
                "None"
        );

        var meats = meatTexts.stream()
                .map(meatText -> new Meat(meatText, 2))
                .collect(Collectors.toList());

        return meats;
    }

    private List<Cheese> selectCheeses() {
        var types = selectMultipleOptions(
                "Select Your Cheeses (you can select multiple):",
                "Queso Fresco",
                "Cheddar",
                "Mozzarella",
                "Kimchi Cheddar",
                "None"
        );
        var cheeses = types.stream()
                .map(type -> new Cheese(type))
                .collect(Collectors.toList());

        return cheeses;
    }

    private List<RegularTopping> selectOtherToppings() {
        var types = selectMultipleOptions(
                "Select Your Other Toppings (you can select multiple):",
                "Avocado",
                "Pineapple",
                "Kimchi",
                "Pickled Jalapenos",
                "Cucumber Slices",
                "Bean Sprouts",
                "None"
        );
        var toppings = types.stream()
                .map(type -> new RegularTopping(type))
                .collect(Collectors.toList());

        return toppings;
    }

    private List<Sauce> selectSauces() {
        var types = selectMultipleOptions(
                "Select Your Sauces (you can select multiple):",
                "Chipotle Mayo",
                "Sriracha",
                "Hoisin Sauce",
                "Cilantro Lime Crema",
                "Miso Mayo",
                "None"
        );
        var sauces = types.stream()
                .map(type -> new Sauce(type))
                .collect(Collectors.toList());

        return sauces;
    }

    private boolean selectToasting() {
        System.out.println("\nWould you like your sandwich toasted? (yes/no): ");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("yes");
    }

    // Utility method to handle selecting a single option
    private String selectOption(String prompt, String... options) {
        System.out.println("\n" + prompt);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Enter choice (1-" + options.length + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Clear the buffer
        return (choice >= 1 && choice <= options.length) ? options[choice - 1] : options[0];
    }

    // Utility method to handle selecting multiple options
    private List<String> selectMultipleOptions(String prompt, String... options) {
        List<String> selectedOptions = new ArrayList<>();
        System.out.println("\n" + prompt);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Enter choice (comma-separated for multiple choices): ");
        String input = scanner.nextLine();
        String[] choices = input.split(",");

        for (String choice : choices) {
            try {
                int index = Integer.parseInt(choice.trim()) - 1;
                if (index >= 0 && index < options.length) {
                    selectedOptions.add(options[index]);
                } else {
                    System.out.println("Invalid choice: " + choice);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + choice);
            }
        }
        return selectedOptions;
    }

    public void addDrink() {
        System.out.println("\n** Add a Drink to Your Order **");

        var drink = chooseDrink();

        order.addItem(drink);  // Assuming addDrink() is defined in Order class

        System.out.println("\nDrink added to your order!");
        System.out.println(drink);  // Display the drink details
    }

    public Drink chooseDrink() {
        var size = selectSize();
        var type = "";

        while (true) {
            type = selectOption("Please choose a drink:",
                    "Horchata",
                    "Coke",
                    "Bubble Tea",
                    "Lychee");

            switch (type) {
                case "Horchata":
                case "Coke":
                case "Bubble Tea":
                case "Lychee":
                    break;

                default:
                    System.out.println("'" + type + "' is not a valid drink!");
                    continue;
            }

            break;
        }

        return new Drink(type, size);  // Return the selected drink
    }

    public void addChips() {

        System.out.println("\n** Add chips to your order **");

        var chips = chooseChips();

        order.addItem(chips);

        System.out.println("\nChips added to your order!");
        System.out.println(chips);  // Display the drink details
    }

    public Chip chooseChips() {
        // Chip type options
        var type = selectOption("What kind of chips do you want?",
                "Shrimp chips",
                "Plantains");
        var size = selectSize();
        var chips = new Chip(type, size);

        return chips;
    }

    public void checkout() {
        System.out.println(order);

        while (true) {
            System.out.print("Confirm Order? (Y or N): ");
            String confirm = scanner.nextLine().trim().toLowerCase();

            if (confirm.equalsIgnoreCase("y")) {
                OrderFileManager.saveReceipt(order);
                System.out.println("Thank you for your order! Party on, " + customerName + "!");
                break;
            } else if (confirm.equalsIgnoreCase("n")) {
                System.out.println("Order Canceled. No Worries.");
                break;
            } else {
                System.out.println("ERROR: Invalid Choice.");
            }
        }
    }
}


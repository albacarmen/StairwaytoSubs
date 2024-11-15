package com.pluralsight.ui;
import com.pluralsight.IPriceable.Sandwich;
import com.pluralsight.order.Order;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    private Order order;
    private Scanner scanner;
    private String customerName;

    public class UserInterface {
        private Order order;
        private Scanner scanner;

        public UserInterface(Order order) {
            this.order = order;
            this.scanner = new Scanner(System.in);
        }

        // customer greeting


        public void homeScreen() {
            greetCustomer();

            Map<Integer, Runnable> actions = new HashMap<>();
            actions.put(1, this::startNewOrder);
            actions.put(2, this::selectSignatureSandwich); // Added Signature Sandwich option
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
            System.out.println("2) Add Signature Sandwich"); // Added option for Signature Sandwich
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
            actions.put(1, this::addSandwich);
            actions.put(2, this::addDrinkScreen);
            actions.put(3, this::addChipScreen);
            actions.put(4, this::checkoutScreen);
            actions.put(0, this::cancelOrder);

            boolean ordering = true;
            while (ordering) {
                orderScreen();
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
                System.out.println("6. Add Signature Sandwich"); // Added option for Signature Sandwich
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
                    case 6 -> {
                        addSignatureSandwich(); // Add Signature Sandwich when the user selects option 6
                        break; // Break the switch to return to the order screen
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


        public void addSandwich() {
            System.out.println("\n** Add Your Sandwich **");
            System.out.println("1. Create a Custom Sandwich");
            System.out.println("2. Choose a Signature Sandwich (Premium)");

            System.out.print("Enter choice (1 or 2): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            if (choice == 1) {
                createCustomSandwich();
            } else if (choice == 2) {
                selectSignatureSandwich();
            } else {
                System.out.println("Invalid choice. Returning to the order screen.");
            }
        }

        private void createCustomSandwich() {
            System.out.println("\n** Add Your Custom Sandwich **");

            // Select bread type
            String bread = selectBread();

            // Select sandwich size
            String size = selectSize();

            // Add toppings (meats, cheeses, sauces, etc.)
            List<String> meats = selectMeats();
            List<String> cheeses = selectCheeses();
            List<String> otherToppings = selectOtherToppings();
            List<String> sauces = selectSauces();

            // Toasting option
            boolean isToasted = selectToasting();

            // Create the sandwich and add to the order
            Sandwich newSandwich = new Sandwich(bread, size, meats, cheeses, otherToppings, sauces, isToasted);
            order.addSandwich(newSandwich);  // Assuming addSandwich() is defined in the Order class

            System.out.println("\nSandwich added to your order!");
            System.out.println(newSandwich);  // Display the sandwich details
        }

        private void selectSignatureSandwich() {
            System.out.println("\nSelect your signature sandwich (premium):");
            System.out.println("1. Latin Fusion");
            System.out.println("2. Asian Delight");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            Sandwich signatureSandwich = null;
            if (choice == 1) {
                signatureSandwich = new Sandwich("Telera", "Regular",
                        List.of("Carnitas"), List.of("Queso Fresco"),
                        List.of("Avocado", "Cilantro Lime Crema"), List.of("Chipotle Mayo"), false);
            } else if (choice == 2) {
                signatureSandwich = new Sandwich("Banh Mi", "Regular",
                        List.of("Korean BBQ Beef"), List.of("Kimchi Cheddar"),
                        List.of("Sriracha"), List.of("Hoisin Sauce"), false);
            } else {
                System.out.println("Invalid choice.");
                return;
            }

            order.addSandwich(signatureSandwich);
            System.out.println("Signature sandwich added!");
        }

        private String selectBread() {
            return selectOption(
                    "Select Your Bread:",
                    "Telera (Latin American)",
                    "Bao (Asian Steamed Bun)",
                    "Banh Mi (Vietnamese Baguette)",
                    "Bolillo (Mexican Bread)",
                    "Arepa (Venezuelan Bread)"
            );
        }

        private String selectSize() {
            return selectOption(
                    "Select Your Sandwich Size:",
                    "Mini",
                    "Regular",
                    "Giant"
            );
        }

        private List<String> selectMeats() {
            return selectMultipleOptions(
                    "Select Your Meats (you can select multiple):",
                    "Carnitas (Latin American)",
                    "Korean BBQ Beef (Asian Fusion)",
                    "Grilled Chicken with Chipotle (Latin Fusion)",
                    "Teriyaki Pork (Asian Fusion)",
                    "None"
            );
        }

        private List<String> selectCheeses() {
            return selectMultipleOptions(
                    "Select Your Cheeses (you can select multiple):",
                    "Queso Fresco (Latin American)",
                    "Cheddar",
                    "Mozzarella",
                    "Kimchi Cheddar (Fusion)",
                    "None"
            );
        }

        private List<String> selectOtherToppings() {
            return selectMultipleOptions(
                    "Select Your Other Toppings (you can select multiple):",
                    "Avocado (Latin American)",
                    "Pineapple (Fusion)",
                    "Kimchi (Asian Fusion)",
                    "Pickled Jalapenos (Latin American)",
                    "Cucumber Slices (Asian Fusion)",
                    "None"
            );
        }

        private List<String> selectSauces() {
            return selectMultipleOptions(
                    "Select Your Sauces (you can select multiple):",
                    "Chipotle Mayo (Latin American Fusion)",
                    "Sriracha (Asian Fusion)",
                    "Hoisin Sauce (Asian Fusion)",
                    "Cilantro Lime Crema (Latin Fusion)",
                    "Miso Mayo (Asian Fusion)",
                    "None"
            );
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
    }


    public void addDrinkScreen() {
        System.out.println("\n** Add a Drink to Your Order **");

        // Select drink type
        String drinkType = selectDrinkType();

        // Select drink size
        String size = selectSize();

        // Create the drink and add to the order
        Drink newDrink = new Drink(drinkType, size); // Assuming Drink class exists
        currentOrder.addDrink(newDrink);  // Assuming addDrink() is defined in Order class

        System.out.println("\nDrink added to your order!");
        System.out.println(newDrink);  // Display the drink details
    }

    public Drink chooseDrink() {
        // Drink size options
        System.out.println("1. Mini");
        System.out.println("2. Regular");
        System.out.println("3. Giant");

        String size;
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();  // Clear the buffer

        switch (sizeChoice) {
            case 1 -> size = "Mini";
            case 2 -> size = "Regular";
            case 3 -> size = "Giant";
            default -> {
                System.out.println("ERROR: Invalid Choice.");
                size = "Mini";  // Default to "Mini"
            }
        }

        // Drink type options (customized with your specific options)
        System.out.println("SELECT A DRINK:");
        System.out.println("1. Horchata");
        System.out.println("2. Coke");
        System.out.println("3. Bubble Tea");
        System.out.println("4. Lychee");
        System.out.println("PRESS '0' TO END SELECTION");

        String type;
        int typeChoice = scanner.nextInt();
        scanner.nextLine();  // Clear the buffer

        switch (typeChoice) {
            case 1 -> type = "Horchata";
            case 2 -> type = "Coke";
            case 3 -> type = "Bubble Tea";
            case 4 -> type = "Lychee";
            default -> {
                System.out.println("ERROR: Invalid Choice.");
                type = "Horchata";  // Default to "Horchata"
            }
        }

        return new Drink(size, type);  // Return the selected drink
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


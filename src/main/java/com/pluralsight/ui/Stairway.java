import com.pluralsight.order.Order;
import com.pluralsight.order.OrderFileManager;
import com.pluralsight.ui.UserInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class Stairway {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // emptylist
        List<IPriceable> orderItems = new ArrayList<>();


        Order order = new Order(orderItems);


        UserInterface ui = new UserInterface(order);


        ui.homeScreen();


        boolean isOrdering = true;
        while (isOrdering) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Start a new order");
            System.out.println("2. Add a sandwich");
            System.out.println("3. Add a drink");
            System.out.println("4. Add chips");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    orderItems.clear();
                    System.out.println("Starting a new order...");
                    break;

                case 2:
                    ui.addSandwichScreen();
                    break;

                case 3:
                    ui.addDrinkScreen();
                    break;

                case 4:
                    ui.addChipScreen();
                    break;

                case 5:
                    ui.checkoutScreen();
                    System.out.println("Would you like to save the receipt? (yes/no)");
                    String saveChoice = scanner.nextLine();
                    if (saveChoice.equalsIgnoreCase("yes")) {
                        OrderFileManager fileManager = new OrderFileManager();
                        fileManager.saveReceipt(order);
                    }
                    isOrdering = false;  // End the loop (exit the app)
                    break;

                case 6:
                    isOrdering = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }


        scanner.close();
    }
}



package com.pluralsight.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.pluralsight.IPriceable.Sandwich;
import com.pluralsight.IPriceable.Drinks;
import com.pluralsight.IPriceable.Chips;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drinks> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();
    private double totalCost;
    private LocalDateTime orderDate;

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void removeSandwich(Sandwich sandwich) {
        sandwiches.remove(sandwich);
    }

    public void pourDrink(Drinks drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }

    public double calculateTotal() {
        // Calculate total cost
        return totalCost;
    }

    public String showDetails() {
        // Return order details
        return "Order details";
    }

    public void saveOrderReceipt() {
        // Save the order receipt
    }

    // Getters and setters
}


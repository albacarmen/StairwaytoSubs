package com.pluralsight.sandwich;

public class Cheese extends PremiumTopping {

    public Cheese(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(String size) {
        switch (size) {
            case "Mini":
                return 0.50;  // Small topping 4 Mini
            case "Regular":
                return 0.75;  // Standard topping 4 Regular
            case "Giant":
                return 1.00;  // Larger topping 4 Giant
            default:
                return 0.75;  // Default price
        }
    }
}




package com.pluralsight.sandwich;

public class Meat extends PremiumTopping {

    public Meat(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(String size) {
        switch (size) {
            case "Mini":
                return 1.00;  // small topping
            case "Regular":
                return 1.50;  // standard topping
            case "Giant":
                return 2.00;  // larger topping
            default:
                return 1.50;  // Default price
        }
    }
}



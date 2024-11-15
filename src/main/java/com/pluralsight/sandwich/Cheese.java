package com.pluralsight.sandwich;

public class Cheese extends PremiumTopping {

    public Cheese(String type) { super(type, 2); }
    public Cheese(String type, int size) {
        super(type, size);
    }

    @Override
    public double calculatePrice() {
        switch (size) {
            case 1:
                return 0.50;  // Small topping 4 Mini
            case 2:
                return 0.75;  // Standard topping 4 Regular
            case 3:
                return 1.00;  // Larger topping 4 Giant
            default:
                return 0.0;
        }
    }
}




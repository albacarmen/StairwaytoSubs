package com.pluralsight.sandwich;

public class Sauces extends Topping {

    public Sauces(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(int size) {
        // Implement pricing logic for sauces
        return 0.3 * size; // Example: Price increases based on sandwich size
    }
}

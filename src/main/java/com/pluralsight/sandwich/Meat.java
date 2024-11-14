package com.pluralsight.sandwich;

public class Meat extends PremiumTopping {

    public Meat(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(int size) {
        // logic for meat
        return 2.0 * size; // higher price based on size
    }
}


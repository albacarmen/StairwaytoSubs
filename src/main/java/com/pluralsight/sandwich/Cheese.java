package com.pluralsight.sandwich;

public class Cheese extends PremiumTopping {

    public Cheese(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(int size) {
        // Price calculation based on the size of the sandwich
        return 0.75 * (size / 4.0);
    }
}



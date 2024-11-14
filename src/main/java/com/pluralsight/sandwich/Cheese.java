package com.pluralsight.sandwich;

public class Cheese extends PremiumTopping {

    public Cheese(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(int size) {
        // logic for cheese
        return 1.5 * size; //  premium price
    }
}


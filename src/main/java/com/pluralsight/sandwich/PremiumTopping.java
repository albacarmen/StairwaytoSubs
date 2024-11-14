package com.pluralsight.sandwich;

public abstract class PremiumTopping extends Topping {

    public PremiumTopping(String type) {
        super(type);
    }

    @Override
    public abstract double calculatePrice(int size);
}


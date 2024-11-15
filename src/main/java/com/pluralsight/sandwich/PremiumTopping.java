package com.pluralsight.sandwich;

public abstract class PremiumTopping extends Topping {

    public PremiumTopping(String type, int size) {
        super(type, size); // Call the parent constructor to set the type of topping
    }

    // Premium toppings will have their own specific price calculation
    @Override
    public abstract double calculatePrice();
}


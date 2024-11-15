package com.pluralsight.sandwich;

public class RegularTopping extends Topping {

    public RegularTopping(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(String size) {
        return 0.00;  // No extra charge for regular toppings
    }
}



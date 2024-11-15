package com.pluralsight.sandwich;

public class RegularTopping extends Topping {

    public RegularTopping(String type) {
        super(type, 2);
    }

    public RegularTopping(String type, int size) {
        super(type, size);
    }

    @Override
    public double calculatePrice() {
        return 0.0; // No extra charge for regular toppings
    }
}



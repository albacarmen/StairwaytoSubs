package com.pluralsight.sandwich;

public class Sauce extends Topping {

    // super constructor of Topping
    public Sauce(String type) {
        super(type, 2);
    }
    public Sauce(String type, int size) {
        super(type, size);
    }

    @Override
    public double calculatePrice() {
        return 0.0;  //  no charge for sauces, feels rude to charge
    }
}


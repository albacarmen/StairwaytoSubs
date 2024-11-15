package com.pluralsight.sandwich;

public class Sauce extends Topping {

    // super constructor of Topping
    public Sauce(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(int size) {
        return 0.0;  //  no charge for sauces, feels rude to charge
    }
}


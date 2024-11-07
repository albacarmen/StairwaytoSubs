package com.pluralsight.otherproducts;

import com.pluralsight.order.IOrderable;

public class Drink implements IOrderable {
    private DrinkSize size;
    private double cost;

    @Override
    public double calculateCost() {
        return cost;
    }

    @Override
    public String showDetails() {
        return "Drink details";
    }

    // Getters and setters
}


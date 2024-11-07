package com.pluralsight.otherproducts;

import com.pluralsight.order.IOrderable;

public class Chip implements IOrderable {
    private String type;
    private double cost;

    @Override
    public double calculateCost() {
        return cost;
    }

    @Override
    public String showDetails() {
        return "Chip details";
    }

    // Getters and setters
}


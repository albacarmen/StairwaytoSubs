package com.pluralsight.IPriceable;

import com.pluralsight.order.Order;

public class Chips implements IPriceable {
    private String type;

    public Chip(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public double getPrice() {
        // Implement chip price logic
        return 2.5; // example price for chips
    }

    @Override
    public String toString() {
        return "Chip{" +
                "type='" + type + '\'' +
                '}';
    }
}



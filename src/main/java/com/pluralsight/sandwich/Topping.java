package com.pluralsight.sandwich;

public abstract class Topping {
    private String type;

    public Topping(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract double calculatePrice(int size); // price based on size
}



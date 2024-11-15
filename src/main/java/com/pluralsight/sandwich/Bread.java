package com.pluralsight.sandwich;

import com.pluralsight.IPriceable.IPriceable;



public class Bread implements IPriceable {
    private String type;  // you will see in userinterface

    public Bread(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + " Bread";
    }

    @Override
    public double calculatePrice() {
        return 0.0;
    }
}

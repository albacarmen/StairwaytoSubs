package com.pluralsight.sandwich;

import com.pluralsight.sandwich.Sandwich;

public class SignatureSandwich extends Sandwich {
    private String name;

    @Override
    public double crunchNumbers() {
        // cost specific to SignatureSandwich
        return 0.0;
    }

    public String getName() {
        return name;
    }

    // Getters and setters
}


package com.pluralsight.IPriceable;

import java.util.List;

import com.pluralsight.sandwich.BreadType;
import com.pluralsight.sandwich.Topping;
import com.pluralsight.topping.Topping;

public abstract class Sandwich {
    private Size size;
    private BreadType breadType;
    private List<Topping> toppings;
    private boolean isToasted;

    public void topUp(Topping topping) {
        toppings.add(topping);
    }

    public void dropTopping(Topping topping) {
        toppings.remove(topping);
    }

    public abstract double crunchNumbers();

    public String getSummary() {
        // Construct and return sandwich details
        return "Sandwich summary";
    }

    // Getters and setters
}


package com.pluralsight.IPriceable;

import com.pluralsight.sandwich.*;

import java.util.List;

public class CustomSandwich extends Sandwich {
    public CustomSandwich(Bread bread, int size, List<Meat> meats, List<Sauce> sauces, List<RegularTopping> toppings, List<Cheese> cheeses, boolean isToasted) {
        super(bread, size, meats, sauces, toppings, cheeses, isToasted);
    }
}

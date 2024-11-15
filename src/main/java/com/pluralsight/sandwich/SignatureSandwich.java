package com.pluralsight.sandwich;

import java.util.List;

public class SignatureSandwich extends Sandwich {
    private String name; // Name of the signature sandwich

    // Constructor for creating a signature sandwich
    public SignatureSandwich(String name, String bread, int size, List<Meat> meats, List<Sauce> sauces, List<RegularTopping> regularToppings, List<Cheese> cheeses, boolean isToasted) {
        super(bread, size, meats, sauces, regularToppings, cheeses, isToasted); // Initialize the base sandwich
        this.name = name; // Set the name of the signature sandwich
    }

    @Override
    public double calculatePrice() {
        double price = super.calculatePrice(); // base price from Sandwich

        // Add custom price for special signature sandwiches
        if ("Party On, The Fusion Special".equals(name)) {
            price += 5.00; // Special price for this fusion sandwich
        }

        return price;
    }

    public String getName() {
        return name; // Get the name of the signature sandwich
    }

    @Override
    public String toString() {
        return "SignatureSandwich{" +
                "name='" + name + '\'' +
                ", bread='" + getBread() + '\'' +
                ", size=" + getSize() +
                ", meats=" + getMeats() +
                ", sauces=" + getSauces() +
                ", regularToppings=" + getRegularToppings() +
                ", cheeses=" + getCheeses() +
                ", isToasted=" + isToasted() +
                '}';
    }
}




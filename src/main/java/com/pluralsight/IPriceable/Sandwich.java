package com.pluralsight.IPriceable;

import com.pluralsight.sandwich.Topping;
import java.util.List;

public class Sandwich implements IPriceable {
    private String bread;
    private String size; // "Mini", "Regular", "Giant"
    private List<Topping> toppings;
    private boolean isToasted;

    // Constructor
    public Sandwich(String bread, String size, List<Topping> toppings, boolean isToasted) {
        this.bread = bread;
        this.size = size;
        this.toppings = toppings;
        this.isToasted = isToasted;
    }

    public String getBread() {
        return bread;
    }

    public String getSize() {
        return size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return isToasted;
    }

    // Price based on sandwich size
    private double sandwichPriceSize() {
        switch (size) {
            case "Mini":
                return 9.00;  // Mini sandwich price
            case "Regular":
                return 15.00; // Regular sandwich price
            case "Giant":
                return 19.00; // Giant sandwich price
            default:
                return 15.00; // Default to Regular size if no valid size
        }
    }

    // sandwich's price including toppings
    @Override
    public double getPrice() {
        double totalPrice = sandwichPriceSize();

        // Add price of toppings
        for (Topping topping : toppings) {
            totalPrice += topping.calculatePrice(size);
        }

        return totalPrice;
    }

    // String representation of the sandwich for displaying
    @Override
    public String toString() {
        return "Sandwich{" +
                "bread='" + bread + '\'' +
                ", size='" + size + '\'' +
                ", toppings=" + toppings +
                ", isToasted=" + isToasted +
                '}';
    }
}




package com.pluralsight.IPriceable;

import java.util.List;

import com.pluralsight.sandwich.Topping;



public class Sandwich implements IPriceable {
    private String bread;
    private int size;
    private List<Topping> toppings;
    private boolean isToasted;

    public Sandwich(String bread, int size, List<Topping> toppings, boolean isToasted) {
        this.bread = bread;
        this.size = size;
        this.toppings = toppings;
        this.isToasted = isToasted;
    }

    public String getBread() {
        return bread;
    }

    public int getSize() {
        return size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return isToasted;
    }

    @Override
    public double getPrice() {

        double price = 5.0; // base price
        for (Topping topping : toppings) {
            price += topping.calculatePrice(size);
        }
        return price;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "bread='" + bread + '\'' +
                ", size=" + size +
                ", toppings=" + toppings +
                ", isToasted=" + isToasted +
                '}';
    }
}



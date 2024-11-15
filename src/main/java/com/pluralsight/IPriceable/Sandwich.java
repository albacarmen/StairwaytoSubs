package com.pluralsight.IPriceable;

import com.pluralsight.sandwich.Topping;
import com.pluralsight.sandwich.Meat;
import com.pluralsight.sandwich.Sauce;
import com.pluralsight.sandwich.Cheese;
import com.pluralsight.sandwich.RegularTopping;


import java.util.List;
import java.util.stream.Collectors;

public class Sandwich implements IPriceable {
    private String bread;
    private int size; // "Mini", "Regular", "Giant"
    private List<Topping> toppings;
    private List<Meat> meats;
    private List<Sauce> sauces;
    private List<Cheese> cheeses;
    private boolean isToasted;

    public Sandwich(String bread, int size, List<Meat> meats, List<Sauce> sauces, List<RegularTopping> toppings, List<Cheese> cheeses, boolean isToasted) {
        this.bread = bread;
        this.size = size;
        this.toppings = toppings.stream().map(t -> (Topping) t).collect(Collectors.toList());
        this.meats = meats;
        this.sauces = sauces;
        this.cheeses = cheeses;
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

    public List<Meat> getMeats() {
        return meats;
    }

    public List<Sauce> getSauces() {
        return sauces;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }

    public boolean isToasted() {
        return isToasted;
    }

    private double sandwichPriceSize() {
        switch (size) {
            case 1:
                return 9.00;
            case 2:
                return 15.00;
            case 3:
                return 19.00;
            default:
                return 15.00; // Default price for "Regular"
        }
    }

    private double calculateRegularToppingPrice() {
        return toppings.stream()
                .filter(topping -> topping instanceof RegularTopping)
                .mapToDouble(topping -> topping.calculatePrice())
                .sum();
    }

    private double calculatePremiumToppingPrice() {
        return toppings.stream()
                .filter(topping -> !(topping instanceof RegularTopping))
                .mapToDouble(topping -> topping.calculatePrice())
                .sum();
    }

    @Override
    public double calculatePrice() {

        return sandwichPriceSize()
                + meats.stream().mapToDouble(meat -> meat.calculatePrice()).sum()
                + sauces.stream().mapToDouble(sauce -> sauce.calculatePrice()).sum()
                + cheeses.stream().mapToDouble(cheese -> cheese.calculatePrice()).sum()
                + calculateRegularToppingPrice()
                + calculatePremiumToppingPrice();
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "bread='" + bread + '\'' +
                ", size='" + size + '\'' +
                ", meats=" + meats +
                ", sauces=" + sauces +
                ", cheeses=" + cheeses +
                ", toppings=" + toppings +
                ", isToasted=" + isToasted +
                '}';
    }
}








package com.pluralsight.IPriceable;

import com.pluralsight.sandwich.*;


import java.util.List;
import java.util.stream.Collectors;

public abstract class Sandwich implements IPriceable {
    protected Bread bread;
    protected int size;
    protected List<RegularTopping> toppings;
    protected List<Meat> meats;
    protected List<Sauce> sauces;
    protected List<Cheese> cheeses;
    protected boolean isToasted;

    public Sandwich(Bread bread, int size, List<Meat> meats, List<Sauce> sauces, List<RegularTopping> toppings, List<Cheese> cheeses, boolean isToasted) {
        this.bread = bread;
        this.size = size;
        this.toppings = toppings;
        this.meats = meats;
        this.sauces = sauces;
        this.cheeses = cheeses;
        this.isToasted = isToasted;
    }

    public Bread getBread() {
        return bread;
    }

    public int getSize() {
        return size;
    }

    public String getSizeText() {
        switch (size) {
            case 1:
                return "Mini";

            case 2:
                return "Regular";

            case 3:
                return "Giant";

            default:
                return "Invalid";
        }
    }

    public List<RegularTopping> getToppings() {
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
                + bread.calculatePrice()
                + meats.stream().mapToDouble(meat -> meat.calculatePrice()).sum()
                + sauces.stream().mapToDouble(sauce -> sauce.calculatePrice()).sum()
                + cheeses.stream().mapToDouble(cheese -> cheese.calculatePrice()).sum()
                + calculateRegularToppingPrice()
                + calculatePremiumToppingPrice();
    }

    private static <T> String getToppingText(String title, List<T> toppings) {
        var text = "\n\t" + title + ":";

        for (var topping : toppings) {
            text += "\n\t\t" + topping;
        }

        return text;
    }

    @Override
    public String toString() {
        var text = new StringBuilder();

        text.append("Sandwich:");
        text.append("\n\tBread: " + bread);
        text.append("\n\tSize: " + getSizeText());
        text.append(getToppingText("Meats", meats));
        text.append(getToppingText("Cheeses", cheeses));
        text.append(getToppingText("Sauces", sauces));
        text.append(getToppingText("Toppings", toppings));
        text.append("\n\tIs toasted: " + isToasted);
        text.append("\n\n\tPrice: $" + calculatePrice());
        text.append("\n");

        return text.toString();
    }
}








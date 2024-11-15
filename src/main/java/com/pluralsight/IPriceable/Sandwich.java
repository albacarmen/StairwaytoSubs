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
    private String size;
    private List<Topping> toppings;
    private List<Meat> meats;
    private List<Sauce> sauces;
    private List<Cheese> cheeses;
    private boolean isToasted;

    public Sandwich(String bread, int size, List<Meat> toppings, List<Sauce> meats, List<RegularTopping> sauces, List<Cheese> cheeses, boolean isToasted) {
        this.bread = bread;
        this.size = size;
        this.toppings = toppings;
        this.meats = meats;
        this.sauces = sauces;
        this.cheeses = cheeses;
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
            case "Mini":
                return 9.00;
            case "Regular":
                return 15.00;
            case "Giant":
                return 19.00;
            default:
                return 15.00;
        }
    }

    private double calculateRegularToppingPrice() {
        List<RegularTopping> regularToppings = toppings.stream()
                .filter(topping -> topping instanceof RegularTopping)
                .map(topping -> (RegularTopping) topping)
                .collect(Collectors.toList());

        return regularToppings.stream()
                .mapToDouble(topping -> topping.calculatePrice(size))
                .sum();
    }

    private double calculateNonRegularToppingPrice() {
        return toppings.stream()
                .filter(topping -> !(topping instanceof RegularTopping))
                .mapToDouble(topping -> topping.calculatePrice(size))
                .sum();
    }

    @Override
    public double getPrice() {
        double totalPrice = sandwichPriceSize();

        totalPrice += meats.stream().mapToDouble(meat -> meat.calculatePrice(size)).sum();
        totalPrice += sauces.stream().mapToDouble(sauce -> sauce.calculatePrice(size)).sum();
        totalPrice += cheeses.stream().mapToDouble(cheese -> cheese.calculatePrice(size)).sum();
        totalPrice += calculateRegularToppingPrice();
        totalPrice += calculateNonRegularToppingPrice();

        return totalPrice;
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







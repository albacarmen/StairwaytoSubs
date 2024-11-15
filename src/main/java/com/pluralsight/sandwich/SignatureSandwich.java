package com.pluralsight.sandwich;

import com.pluralsight.IPriceable.Sandwich;
import java.util.List;

public class SignatureSandwich extends Sandwich {
    private String name;

    public SignatureSandwich(String name, String bread, int size, List<Meat> meats, List<Sauce> sauces, List<RegularTopping> regularToppings, List<Cheese> cheeses, boolean isToasted) {
        super(bread, size, meats, sauces, regularToppings, cheeses, isToasted);
        this.name = name;
    }

    @Override
    public double calculatePrice() {
        double price = super.calculatePrice();

        if ("Party On, The Fusion Special".equals(name)) {
            price += 5.00; // Special price for this fusion sandwich
        }

        return price;
    }

    public String getName() {
        return name;
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





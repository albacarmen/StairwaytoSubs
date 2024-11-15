package com.pluralsight.IPriceable;

import com.pluralsight.sandwich.*;

import java.util.List;

public class AsianSandwich extends Sandwich {
    public AsianSandwich() {
        super(
                new Bread("Banh Mi"),
                2,
                List.of(new Meat("Teriyaki Pork")),
                List.of(new Sauce("Chipotle Mayo")),
                List.of(new RegularTopping("Kimchi"), new RegularTopping("Bean Sprouts")),
                List.of(new Cheese("Kimchi Cheddar")),
                true
        );
    }

    @Override
    public double calculatePrice() {
        return super.calculatePrice() - 3.0;
    }
}

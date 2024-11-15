package com.pluralsight.IPriceable;

import com.pluralsight.sandwich.*;

import java.util.List;

public class LatinSandwich extends Sandwich {
    public LatinSandwich() {
        super(
            new Bread("Telera"),
            2,
            List.of(new Meat("Carnitas")),
            List.of(new Sauce("Chipotle Mayo")),
            List.of(new RegularTopping("Avocado")),
            List.of(new Cheese("Queso Fresco")),
            true
        );
    }

    @Override
    public double calculatePrice() {
        return 1.0;
    }
}

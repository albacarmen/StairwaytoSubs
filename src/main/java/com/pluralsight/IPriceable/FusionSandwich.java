package com.pluralsight.IPriceable;

import com.pluralsight.sandwich.*;

import java.util.List;

public class FusionSandwich extends Sandwich {
    public FusionSandwich() {
        super(
            new Bread("Bolillo"),
        3,
            List.of(new Meat("Carnitas")),
            List.of(new Sauce("Sriracha"), new Sauce("Cilantro Lime Crema")),
            List.of(new RegularTopping("Pickled Jalapenos"), new RegularTopping("Cucumber Slices"), new RegularTopping("Pineapple")),
            List.of(new Cheese("Mozzarella")),
            true
        );
    }

    @Override
    public double calculatePrice() {
        return super.calculatePrice() + 4.0;
    }
}

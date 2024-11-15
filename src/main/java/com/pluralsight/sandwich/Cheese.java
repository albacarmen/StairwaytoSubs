package com.pluralsight.sandwich;

public class Cheese extends PremiumTopping {

    public Cheese(String type) {
        super(type, 2, getCheesePrice(type));
    }

    private static double getCheesePrice(String type) {
        return switch (type) {
            case "Queso Fresco" -> 1.5;
            case "Cheddar" -> 1;
            case "Mozzarella" -> 2.0;
            case "Kimchi Cheddar" -> 3;
            case "None" -> 0;
            default -> 0;
        };
    }
}




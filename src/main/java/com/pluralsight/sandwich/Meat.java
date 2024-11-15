package com.pluralsight.sandwich;

public class Meat extends PremiumTopping {
    public Meat(String type) {
        super(type, 2, getMeatPrice(type));
    }

    private static double getMeatPrice(String type) {
        return switch (type) {
            case "Carnitas" -> 2;
            case "Korean BBQ Beef" -> 4;
            case "Grilled Chicken with Chipotle" -> 1;
            case "Teriyaki Pork" -> 2.5;
            case "None" -> 0;
            default -> 0;
        };
    }
}




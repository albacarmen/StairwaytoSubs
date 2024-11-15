package com.pluralsight.sandwich;

public abstract class PremiumTopping extends Topping {
    protected double price;

    public PremiumTopping(String type, int size, double price) {
        super(type, size); // Call the parent constructor to set the type of topping
        this.price = price;
    }

    @Override
    public String toString() {
        var sizeText = getSizeText();
        return sizeText + " " + type + ": +$" + calculatePrice();
    }

    // Premium toppings will have their own specific price calculation
    @Override
    public double calculatePrice() {
        var multiplier = switch (size) {
            case 1 -> 0.75;
            case 2 -> 1.0;
            case 3 -> 1.5;
            default -> 0.0;
        };
        var total = price * multiplier;

        return total;
    }
}


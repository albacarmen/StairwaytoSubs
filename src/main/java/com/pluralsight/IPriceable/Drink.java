package com.pluralsight.IPriceable;



public class Drink implements IPriceable {
    private String flavor;  // "Coca-Cola", "Bubble Tea", "Horchata"
    private int size;       // 1: Mini, 2: Regular, 3: Giant

    // Price mapping for different drink flavors and sizes
    private static final double[][] DRINK_PRICES = {
            {3.00, 3.50, 4.00}, // Bubble Tea
            {1.75, 2.25, 2.75},  // Horchata
            {2.00, 2.50, 3.00}, // Coca-Cola
    };

    private static final String[] DRINK_FLAVORS = {"Coca-Cola", "Bubble Tea", "Horchata"};

    public Drink(String flavor, int size) {
        this.flavor = flavor;
        this.size = size;
    }

    @Override
    public String toString() {
        var text = new StringBuilder();

        text.append("Drink:");
        text.append("\n\tFlavor: " + flavor);
        text.append("\n\tSize: " + getSizeString());
        text.append("\n");

        return text.toString();
    }


    @Override
    public double calculatePrice() {
        int flavorIndex = getFlavorIndex(flavor);
        if (flavorIndex == -1) return 0.0;
        return DRINK_PRICES[flavorIndex][size - 1];
    }

    // Get index of the drink flavor
    private int getFlavorIndex(String flavor) {
        for (int i = 0; i < DRINK_FLAVORS.length; i++) {
            if (DRINK_FLAVORS[i].equalsIgnoreCase(flavor)) {
                return i;
            }
        }
        return -1;
    }

    // Get size as a string
    private String getSizeString() {
        switch (size) {
            case 1:
                return "Mini";

            case 2:
                return "Regular";

            case 3:
                return "Giant";

            default:
                return "Invalid";  // Default
        }
    }
}



package com.pluralsight.IPriceable;

import java.math.BigDecimal;

public class Drink implements IPriceable {
    private String flavor;  // "Coca-Cola", "Bubble Tea", "Horchata"
    private int size;       // 1: Mini, 2: Regular, 3: Giant

    // Price mapping for different drink flavors and sizes
    private static final BigDecimal[][] DRINK_PRICES = {
            {new BigDecimal("2.00"), new BigDecimal("2.50"), new BigDecimal("3.00")}, // Coca-Cola
            {new BigDecimal("3.00"), new BigDecimal("3.50"), new BigDecimal("4.00")}, // Bubble Tea
            {new BigDecimal("1.75"), new BigDecimal("2.25"), new BigDecimal("2.75")}  // Horchata
    };

    private static final String[] DRINK_FLAVORS = {"Coca-Cola", "Bubble Tea", "Horchata"};

    public Drink(String flavor, int size) {
        this.flavor = flavor;
        this.size = size;
    }

    @Override
    public String toString() {
        return flavor + " (" + getSizeString() + ")";
    }


    @Override
    public BigDecimal calculatePrice() {
        int flavorIndex = getFlavorIndex(flavor);
        if (flavorIndex == -1) return BigDecimal.ZERO;
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
            case 1: return "Mini";
            case 2: return "Regular";
            case 3: return "Giant";
            default: return "Regular";  // Default
        }
    }
}



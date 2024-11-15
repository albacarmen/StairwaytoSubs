package com.pluralsight.IPriceable;



public class Chip implements IPriceable {
    private String type;  // "Shrimp Chips" (Asian), "Plantains" (Latin American)
    private int size;     // 1: Mini, 2: Regular, 3: Giant

    // Price mapping
    private static final double[][] CHIP_PRICES = {
            {1.75, 3.50, 5.25}, // Shrimp Chips
            {1.50, 3.00, 4.50}, // Plantains
    };

    private static final String[] CHIP_TYPES = {"Shrimp Chips", "Plantains"};

    public Chip(String type, int size) {
        this.type = type;
        this.size = size;
    }

    @Override
    public String toString() {
        return type + " (" + getSizeString() + ")";
    }

    @Override
    public double calculatePrice() {
        int typeIndex = getTypeIndex(type);
        if (typeIndex == -1) return 0.0;
        return CHIP_PRICES[typeIndex][size - 1];
    }

    private int getTypeIndex(String type) {
        for (int i = 0; i < CHIP_TYPES.length; i++) {
            if (CHIP_TYPES[i].equalsIgnoreCase(type)) {
                return i;
            }
        }
        return -1;
    }

    private String getSizeString() {
        switch (size) {
            case 1: return "Mini";
            case 2: return "Regular";
            case 3: return "Giant";
            default: return "Regular";  // Default
        }
    }
}








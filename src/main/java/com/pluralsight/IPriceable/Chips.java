package com.pluralsight.IPriceable;

import java.math.BigDecimal;

public class Chips implements IPriceable {
    private String type;  // "Shrimp Chips", "Plantains"
    private int size;     // 1: Mini, 2: Regular, 3: Giant

    // Price mapping for different chip types and sizes
    private static final BigDecimal[][] CHIP_PRICES = {
            {new BigDecimal("1.75"), new BigDecimal("3.50"), new BigDecimal("5.25")}, // Shrimp Chips
            {new BigDecimal("1.50"), new BigDecimal("3.00"), new BigDecimal("4.50")}, // Plantains
    };

    private static final String[] CHIP_TYPES = {"Shrimp Chips", "Plantains"};

    public Chips(String type, int size) {
        this.type = type;
        this.size = size;
    }

    @Override
    public String toString() {
        return type + " (" + getSizeString() + ")";
    }

    @Override
    public BigDecimal getPrice() {
        int typeIndex = getTypeIndex(type);
        if (typeIndex == -1) return BigDecimal.ZERO;  // Default for unknown type
        return CHIP_PRICES[typeIndex][size - 1];  // Get price based on type and size
    }

    // Get index of the chip type
    private int getTypeIndex(String type) {
        for (int i = 0; i < CHIP_TYPES.length; i++) {
            if (CHIP_TYPES[i].equalsIgnoreCase(type)) {
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





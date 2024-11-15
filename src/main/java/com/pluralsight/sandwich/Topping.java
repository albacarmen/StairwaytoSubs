package com.pluralsight.sandwich;

public abstract class Topping {
    protected String type;
    protected int size;

    public Topping(String type, int size) {
        this.type = type;

        if (size < 1 || size > 3)
            size = 2;

        this.size = size;
    }

    public String getSizeText() {
        switch (size) {
            case 1:
                return "Light";

            case 2:
                return "Regular";

            case 3:
                return "Extra";

            default:
                return "Invalid";
        }
    }

    @Override
    public String toString() {
        var sizeText = getSizeText();

        return sizeText + " " + type;
    }

    public String getType() {
        return type;
    }

    public abstract double calculatePrice(); // price based on size
}



package com.pluralsight.sandwich;

public class Meat extends PremiumTopping {

    public Meat(String type) {
        super(type, 2);
    }

    public Meat(String type, int size) {
        super(type, size);
    }

    @Override
    public double calculatePrice() {
        switch (size) {
            case 1:
                return 1.00;  // small topping
            case 2:
                return 1.50;  // standard topping
            case 3:
                return 2.00;  // larger topping
            default:
                return 0.0;
        }
    }


}




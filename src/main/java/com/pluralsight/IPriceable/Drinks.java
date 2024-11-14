package com.pluralsight.IPriceable;
public class Drinks implements IPriceable {
    private String size;
    private String flavor;

    public Drinks(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public double getPrice() {
        // Implement drink price logic
        double price = 1.5; // base price
        if (size.equals("Large")) {
            price += 1.0; // extra charge for large size
        }
        return price;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "size='" + size + '\'' +
                ", flavor='" + flavor + '\'' +
                '}';
    }
}

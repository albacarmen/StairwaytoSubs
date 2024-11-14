package com.pluralsight.order;

import java.util.List;

public class Order {
    private List<IPriceable> items;

    public Order(List<IPriceable> items) {
        this.items = items;
    }

    public List<IPriceable> getItems() {
        return items;
    }

    public double calculatePrice() {
        double totalPrice = 0.0;
        for (IPriceable item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public void checkout() {
        // logic
        System.out.println("Checking out...");
        System.out.println("Total Price: " + calculatePrice());
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                '}';
    }
}



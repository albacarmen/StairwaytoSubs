package com.pluralsight.IPriceable;

import com.pluralsight.order.Order;

public class Chips {
    private String name;
    private Order order;

    public void startOrder() {
        order = new Order();
    }

    public void addSandwichToOrder(Sandwich sandwich) {
        order.addSandwich(sandwich);
    }

    public void finishOrder() {
        order.saveOrderReceipt();
    }

    // Getters and setters
}


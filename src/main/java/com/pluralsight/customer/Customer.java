package com.pluralsight.customer;

import com.pluralsight.order.Order;
import com.pluralsight.sandwich.Sandwich;

public class Customer {
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


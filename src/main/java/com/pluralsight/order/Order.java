package com.pluralsight.order;

import com.pluralsight.IPriceable.IPriceable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private List<IPriceable> items;  // List

    // Constructor to initialize the order with an empty list of items
    public Order() {
        this.items = new ArrayList<>();
    }

    // Adding the goods
    public void addItem(IPriceable item) {
        items.add(item);
    }

    // Removing yucky stuff
    public void removeItem(IPriceable item) {
        items.remove(item);
    }

    // Calculate the total price of the order 
    public BigDecimal getTotalPrice() {
        return items.stream()
                .map(IPriceable::calculatePrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    //  using streams and lambdas
    public String getOrderSummary() {
        String itemsSummary = items.stream()
                .map(item -> item.toString() + " - $" + item.calculatePrice())  // Convert each item to a string with price
                .collect(Collectors.joining("\n"));  // Join all items

        return "Order Summary:\n" + itemsSummary + "\nTotal: $" + getTotalPrice();
    }

    // list of items in the order
    public List<IPriceable> getItems() {
        return items;
    }
}




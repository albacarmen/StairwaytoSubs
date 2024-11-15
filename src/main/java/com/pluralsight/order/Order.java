package com.pluralsight.order;

import com.pluralsight.IPriceable.IPriceable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private List<IPriceable> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(IPriceable orderItem) {
        items.add(orderItem);
    }

    public void removeItem(IPriceable orderItem) {
        items.remove(orderItem);
    }

    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(IPriceable::calculatePrice)
                .sum();
    }

    public String toString() {
        String itemsSummary = items.stream()
                .map(orderItem -> orderItem.toString() + " - $" + orderItem.calculatePrice())
                .collect(Collectors.joining("\n"));

        return "Order Summary:\n" + itemsSummary + "\nTotal: $" + getTotalPrice();
    }

    public List<IPriceable> getItems() {
        return items;
    }
}






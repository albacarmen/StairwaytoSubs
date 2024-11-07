package com.pluralsight.ui;

import com.pluralsight.customer.Customer;
import com.pluralsight.sandwich.Sandwich;
import com.pluralsight.otherproducts.Drink;
import com.pluralsight.otherproducts.Chip;

public class Stairway {
    private Customer customer;
    private UserInterface ui;

    public Stairway() {
        this.customer = new Customer();
        this.ui = new UserInterface();
    }

    public void start() {}
    private void displayHomeScreen() {}
    private void handleOrderScreen() {}
}


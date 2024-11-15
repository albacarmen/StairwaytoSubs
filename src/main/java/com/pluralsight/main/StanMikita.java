package com.pluralsight.main;

import java.util.Scanner;
import com.pluralsight.ui.UserInterface;

public class StanMikita {
    public static void main(String[] args) {
        var ui = new UserInterface();
        ui.homeScreen();  // method exists in UserInterface class
    }
}

// ORDER SUMMARY (weird looking)
// where is txt , where does the receipt go

// Checkout - display the order details and the price

// check out should only have CONFIRM or Cancel
// Confirm - create the receipt file and go back to the home screen
// Cancel - delete order and go back to the home screen
// When exiting, it shows the whole menu again, just show 1. new order or exit






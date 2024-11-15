package com.pluralsight.main;

import java.util.Scanner;
import com.pluralsight.ui.UserInterface;

public class StanMikita {
    public static void main(String[] args) {
        var ui = new UserInterface();
        ui.homeScreen();  // method exists in UserInterface class
    }
}

/*
TO DO:
//Signature Sandwiches are broken
//fucntion to print is not correct

Complete:
    receipt is printing wrong, order summary text
    Checkout - ORDER SUMMARY (weird looking) display the order details and the price: showing it like Sandwich{bread='Telera', size='3' (it's messed up)
    check out should only have CONFIRM or Cancel see next line:
    checkout is exiting the program
    Confirm - create the receipt file and go back to the home screen
    Cancel - delete order and go back to the home screen

    When exiting, it shows the whole menu again, AFTER CONFIRMING ORDER just show 1. new order or exit, then Thanks for your order, party on carmy.
*/







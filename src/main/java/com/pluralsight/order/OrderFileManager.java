package com.pluralsight.order;

import java.io.FileWriter;
import java.io.IOException;

public class OrderFileManager {

    public void saveReceipt(Order order) {
        try (FileWriter writer = new FileWriter("receipt.txt")) {
            writer.write(order.toString());
            writer.write("\nTotal: " + order.calculatePrice());
            System.out.println("Receipt saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}


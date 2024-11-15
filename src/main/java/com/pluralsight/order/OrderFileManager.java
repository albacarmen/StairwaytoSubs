package com.pluralsight.order;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderFileManager {

    public static void saveReceipt(Order order) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = "receipt_" + timestamp + ".txt";

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(order.toString());
            writer.write("\nTotal: " + order.getTotalPrice());  // Ensure `getTotalPrice()` in `Order` class
            System.out.println("Receipt saved successfully as " + filename);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}



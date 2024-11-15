package com.pluralsight.order;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderFileManager {

    public static void saveReceipt(Order order) {
        var timestamp = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss").format(new Date());
        var filename = "receipt_" + timestamp + ".txt";

        try (var writer = new FileWriter(filename)) {
            writer.write(order.toString());
            System.out.println("Receipt saved successfully as " + filename);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}



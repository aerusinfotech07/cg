package com.senario7;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
//To get the total amount of all orders in the orders list, you can use Java Streams and Collectors.summingDouble to sum up the amount field of each ProductOrder.
//Here's an example of how to compute the total amount of all orders:
class ProductOrder {
    int id;
    LocalDate orderDate;
    double amount;
    String status;

    public ProductOrder(int id, LocalDate orderDate, double amount, String status) {
        this.id = id;
        this.orderDate = orderDate;
        this.amount = amount;
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }
}

public class TotalOrderAmount {
    public static void main(String[] args) {
        List<ProductOrder> orders = new ArrayList<>();
        // Add some sample orders
        orders.add(new ProductOrder(1, LocalDate.of(2023, Month.JANUARY, 5), 150.0, "Completed"));
        orders.add(new ProductOrder(2, LocalDate.of(2023, Month.JANUARY, 15), 200.0, "Completed"));
        orders.add(new ProductOrder(3, LocalDate.of(2023, Month.FEBRUARY, 10), 300.0, "Completed"));
        orders.add(new ProductOrder(4, LocalDate.of(2023, Month.MARCH, 25), 400.0, "Completed"));
        orders.add(new ProductOrder(5, LocalDate.of(2023, Month.MARCH, 30), 100.0, "Completed"));

        // Calculate the total amount of all orders
        double totalAmount = orders.stream()
                .mapToDouble(ProductOrder::getAmount)
                .sum();

        // Print the total amount
        System.out.println("Total ProductOrder Amount: " + totalAmount);
    }
}

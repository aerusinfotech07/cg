package com.senario7;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
/*
 * To get a status-wise total amount summary, you can group the orders by their status and calculate the total amount for each status using Java Streams and Collectors.groupingBy along with Collectors.summingDouble.
 */
class OrderStatus {
    int id;
    LocalDate orderDate;
    double amount;
    String status;

    public OrderStatus(int id, LocalDate orderDate, double amount, String status) {
        this.id = id;
        this.orderDate = orderDate;
        this.amount = amount;
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}

public class StatusWiseTotalAmount {
    public static void main(String[] args) {
        List<OrderStatus> orders = new ArrayList<>();
        // Add some sample orders
        orders.add(new OrderStatus(1, LocalDate.of(2023, Month.JANUARY, 5), 150.0, "Completed"));
        orders.add(new OrderStatus(2, LocalDate.of(2023, Month.JANUARY, 15), 200.0, "Pending"));
        orders.add(new OrderStatus(3, LocalDate.of(2023, Month.FEBRUARY, 10), 300.0, "Completed"));
        orders.add(new OrderStatus(4, LocalDate.of(2023, Month.MARCH, 25), 400.0, "Cancelled"));
        orders.add(new OrderStatus(5, LocalDate.of(2023, Month.MARCH, 30), 100.0, "Completed"));
        orders.add(new OrderStatus(6, LocalDate.of(2023, Month.APRIL, 1), 250.0, "Pending"));

        // Group orders by status and calculate the total amount for each status
        Map<String, Double> statusSummary = orders.stream()
                .collect(Collectors.groupingBy(
                        OrderStatus::getStatus, 
                        Collectors.summingDouble(OrderStatus::getAmount)
                ));

        // Print the status-wise total amount summary
        statusSummary.forEach((status, totalAmount) -> {
            System.out.println(status + ": " + totalAmount);
        });
    }
}

/*
 Output
Completed: 550.0
Pending: 450.0
Cancelled: 400.0

*/
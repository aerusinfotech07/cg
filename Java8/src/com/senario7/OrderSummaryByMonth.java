package com.senario7;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

class Order {
    int id;
    LocalDate orderDate;
    double amount;
    String status;

    public Order(int id, LocalDate orderDate, double amount, String status) {
        this.id = id;
        this.orderDate = orderDate;
        this.amount = amount;
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getAmount() {
        return amount;
    }
}

public class OrderSummaryByMonth {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        // Add some sample orders
        orders.add(new Order(1, LocalDate.of(2023, Month.JANUARY, 5), 150.0, "Completed"));
        orders.add(new Order(2, LocalDate.of(2023, Month.JANUARY, 15), 200.0, "Completed"));
        orders.add(new Order(3, LocalDate.of(2023, Month.FEBRUARY, 10), 300.0, "Completed"));
        orders.add(new Order(4, LocalDate.of(2023, Month.MARCH, 25), 400.0, "Completed"));
        orders.add(new Order(5, LocalDate.of(2023, Month.MARCH, 30), 100.0, "Completed"));

        // Group orders by month and year and calculate the total amount for each month
        Map<String, Double> monthlySummary = orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.getOrderDate().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " " + order.getOrderDate().getYear(),
                        Collectors.summingDouble(Order::getAmount)
                ));

        // Print the monthly summary
        monthlySummary.forEach((month, totalAmount) -> {
            System.out.println(month + ": " + totalAmount);
        });
    }
}
/* Output
January 2023: 350.0
February 2023: 300.0
March 2023: 500.0
*/
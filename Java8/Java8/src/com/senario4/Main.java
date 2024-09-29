package com.senario4;

//Scenario 4: Transaction Processing System
//Question: You have a list of transactions with their IDs, amounts, and statuses. Write a program to calculate the total amount of all completed transactions.

import java.util.*;
import java.util.stream.*;

class Transaction {
    private String id;
    private double amount;
    private String status;

    // Constructor, getters, and setters
    public Transaction(String id, double amount, String status) {
        this.id = id;
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

public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("T1", 100.00, "COMPLETED"),
            new Transaction("T2", 200.00, "PENDING"),
            new Transaction("T3", 150.00, "COMPLETED")
        );

        double totalCompletedAmount = transactions.stream()
            .filter(t -> "COMPLETED".equals(t.getStatus()))
            .mapToDouble(Transaction::getAmount)
            .sum();

        System.out.println("Total amount of completed transactions: " + totalCompletedAmount);
    }
}


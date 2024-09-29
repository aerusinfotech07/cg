package com.senario3;

//Scenario 3: Product Filtering System
//Question: You have a list of products with their names, categories, and prices. Write a program to filter out products that belong to a specific category and sort them by price in ascending order.

import java.util.*;
import java.util.stream.*;

class Product {
    private String name;
    private String category;
    private double price;

    // Constructor, getters, and setters
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200.00),
            new Product("Smartphone", "Electronics", 800.00),
            new Product("Desk", "Furniture", 150.00),
            new Product("Chair", "Furniture", 85.00)
        );

        List<Product> filteredProducts = products.stream()
            .filter(p -> "Electronics".equals(p.getCategory()))
            .sorted(Comparator.comparingDouble(Product::getPrice))
            .collect(Collectors.toList());

        filteredProducts.forEach(p -> 
            System.out.println(p.getName() + ": " + p.getPrice())
        );
    }
}

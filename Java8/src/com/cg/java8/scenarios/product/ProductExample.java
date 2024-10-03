package com.cg.java8.scenarios.product;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private double price;
    private int stock;

    public Product(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + ", stock=" + stock + '}';
    }
}

public class ProductExample {

    private List<Product> getProducts() {
        return List.of(
                new Product("Laptop", "Electronics", 1200.00, 30),
                new Product("Smartphone", "Electronics", 800.00, 50),
                new Product("Coffee Maker", "Home Appliances", 150.00, 20),
                new Product("Desk", "Furniture", 250.00, 10),
                new Product("Chair", "Furniture", 100.00, 15)
        );
    }

    public void runExamples() {
        List<Product> productList = getProducts();

        // 1. Filter: Find products in the Electronics category
        List<Product> electronics = productList.stream()
                .filter(product -> product.getCategory().equals("Electronics"))
                .collect(Collectors.toList());
        System.out.println("Electronics: " + electronics);

        // 2. Map: Get a list of product names
        List<String> productNames = productList.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println("Product names: " + productNames);

        // 3. Total Stock: Calculate total stock of all products
        int totalStock = productList.stream()
                .mapToInt(Product::getStock)
                .sum();
        System.out.println("Total stock of all products: " + totalStock);

        // 4. Grouping: Count products by category
        Map<String, Long> productsByCategory = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        System.out.println("Count of products by category: " + productsByCategory);

        // 5. Sorted: Sort products by price
        List<Product> sortedProducts = productList.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
        System.out.println("Products sorted by price: " + sortedProducts);
    }

    public static void main(String[] args) {
        ProductExample example = new ProductExample();
        example.runExamples();
    }
}

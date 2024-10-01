package com.senario6;

import java.util.Arrays;
import java.util.List;

/*Let’s create a scenario where we have Customer, Order, and Product entities. A Customer can have multiple Orders (one-to-many relationship), and each Order can have multiple Products (many-to-many relationship). We’ll use Java 8 features to implement this.
 * 
 */
public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("P1", "Laptop", 1000.0);
        Product product2 = new Product("P2", "Smartphone", 500.0);

        List<Product> productsOrder1 = Arrays.asList(product1, product2);
        List<Product> productsOrder2 = Arrays.asList(product2);

        Customer customer = new Customer("C1", "John Doe", null);

        Order order1 = new Order("O1", customer, productsOrder1);
        Order order2 = new Order("O2", customer, productsOrder2);

        List<Order> orders = Arrays.asList(order1, order2);
        customer = new Customer("C1", "John Doe", orders);

        // Display customer orders and products
        customer.getOrders().forEach(order -> {
            System.out.println("Order ID: " + order.getId());
            order.getProducts().forEach(product -> {
                System.out.println("Product Name: " + product.getName() + ", Price: " + product.getPrice());
            });
        });
    }
}


package com.senario6;

import java.util.List;

public class Order {
    private String id;
    private Customer customer;
    private List<Product> products;

    public Order(String id, Customer customer, List<Product> products) {
        this.id = id;
        this.customer = customer;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }
}


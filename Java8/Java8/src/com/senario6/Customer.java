package com.senario6;

import java.util.List;

public class Customer {
    private String id;
    private String name;
    private List<Order> orders;

    public Customer(String id, String name, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.orders = orders;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }
}

package com.cg.java8.defaultstaticinterfacemethods.impl;

import com.cg.java8.defaultstaticinterfacemethods.interfaces.Vehicle;

public class Motorbike implements Vehicle {

    private final String brand;

    public Motorbike(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "The motorbike is speeding up.";
    }

    @Override
    public String slowDown() {
        return "The motorbike is slowing down.";
    }
}
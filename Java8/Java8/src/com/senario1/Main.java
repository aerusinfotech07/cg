package com.senario1;

// Employee Management System
//Question: You have a list of employees with their names, ages, and salaries. Write a program to find the average salary of employees older than 30 using Java 8.
import java.util.*;
import java.util.stream.*;

class Employee {
    private String name;
    private int age;
    private double salary;

    // Constructor, getters, and setters
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", 35, 50000),
            new Employee("Jane", 28, 60000),
            new Employee("Jack", 40, 70000)
        );

        double averageSalary = employees.stream()
            .filter(e -> e.getAge() > 30)
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0.0);

        System.out.println("Average salary of employees older than 30: " + averageSalary);
    }
}


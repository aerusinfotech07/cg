package com.senario1;

// Employee Management System
//Question: You have a list of employees with their names, ages, and salaries. Write a program to find the average salary of employees older than 30 using Java 8.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
    
    
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", 35, 50000),
            new Employee("Smith", 28, 60000),
            new Employee("Jack", 40, 70000)
        );
        
        List<Employee> employeesList= employees.stream()
        		.filter(emp->emp.getAge()>35)
        		.collect(Collectors.toList());
        
        
        employees.forEach(emp->{
        	System.out.println(emp.getName()+" "+emp.getAge()+" "+emp.getSalary());
        });
        
        //list of emp salary greater than 60000
        
        employees.forEach(emp->{
        	if(emp.getSalary()>=60000)
        		System.out.println(emp.getName()+" "+emp.getAge()+" "+emp.getSalary());
        });
        
        employees.stream().filter(emp->emp.getName().toLowerCase().startsWith("j")).forEach(emp->{
        	System.out.println(emp.getName()+" "+emp.getAge()+" "+emp.getSalary());
        });
    
        
        
        List<Employee> empList=new ArrayList<>();
        empList.add( new Employee("John", 35, 50000));
        empList.add(new Employee("Jane", 28, 60000));
        empList.add( new Employee("Jack", 40, 70000));
        
        
        
        
        
        

        double averageSalary = employees.stream()
            .filter(e -> e.getAge() > 30)
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0.0);

        System.out.println("Average salary of employees older than 30: " + averageSalary);
    }
}


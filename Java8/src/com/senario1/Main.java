package com.senario1;

// Employee Management System
//Question: You have a list of employees with their names, ages, and salaries. Write a program to find the average salary of employees older than 30 using Java 8.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        
        double sumSaalary=employees.stream()
        		.mapToDouble(Employee::getSalary)
        		.sum();
        long count=employees.stream().count();
        
        List<String> empNames=employees.stream()
        .map(Employee::getName)
        .map(String::toUpperCase)
        .collect(Collectors.toList());
        
        List<String> empNamesWithCapital=empNames.stream()
        		.map(String::toUpperCase)
        		.collect(Collectors.toList());
        
        
        
        
        
        
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
    
        
        Collections.sort(employees,new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return 0;
			}
        	
		});
        
        
        Collections.sort(employees,(p1,p2)->{
        	return p1.getName().compareTo(p2.getName());
        });
        
        Collections.sort(employees,Comparator.comparing(Employee::getSalary).reversed());
        
        double highestSlary=employees.get(0).getSalary();
        
        Stream<Employee> emp=employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(1);
        emp.findFirst().get().getSalary();
        
        double maxSalaryEmployee=employees.stream().max(Comparator.comparing(Employee::getSalary).reversed()).get().getSalary();
        
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


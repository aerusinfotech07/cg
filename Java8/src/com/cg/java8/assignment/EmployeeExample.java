package com.cg.java8.assignment;

import java.util.*;
import java.util.stream.Collectors;

enum EmpGender {
    MALE, FEMALE
}

class Employee {
    private String name;
    private int age;
    private EmpGender gender;
    private String department;

    public Employee(String name, int age, EmpGender gender, String department) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public EmpGender getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", gender=" + gender + ", department='" + department + "'}";
    }
}

public class EmployeeExample {

    private List<Employee> getEmployees() {
        return List.of(
                new Employee("Alice", 30, EmpGender.FEMALE, "HR"),
                new Employee("Bob", 25, EmpGender.MALE, "IT"),
                new Employee("Charlie", 28, EmpGender.MALE, "Finance"),
                new Employee("Diana", 35, EmpGender.FEMALE, "IT"),
                new Employee("Eve", 29, EmpGender.FEMALE, "Marketing"),
                new Employee("Frank", 22, EmpGender.MALE, "HR"),
                new Employee("Grace", 27, EmpGender.FEMALE, "Finance"),
                new Employee("Hank", 40, EmpGender.MALE, "IT")
        );
    }

 // Method to find an employee by name using Optional
    private Optional<Employee> findEmployeeByName(String name) {
        return getEmployees().stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .findFirst();
    }


    public void runExamples() {
        List<Employee> employeeList = getEmployees();

        // Count of male and female employees
        Map<EmpGender, Long> genderCount = getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Count of employees by gender: " + genderCount);

        // Example: Filter employees by department
        List<Employee> itEmployees = employeeList.stream()
                .filter(employee -> employee.getDepartment().equals("IT"))
                .collect(Collectors.toList());
        System.out.println("IT Employees: " + itEmployees);

        // Example: Get the average age of employees
        double averageAge = employeeList.stream()
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0);
        System.out.println("Average age of employees: " + averageAge);

        // Example: List all unique departments
        String uniqueDepartments = employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println("Unique Departments: " + uniqueDepartments);
        
     // Example: Find an employee by name
        String searchName = "Diana"; // This can be any employee name
        Optional<Employee> employeeOptional = findEmployeeByName(searchName);

        // Handle the Optional
        employeeOptional.ifPresentOrElse(
            employee -> System.out.println("Found employee: " + employee),
            () -> System.out.println("Employee with name '" + searchName + "' not found.")
        );

        // Example: Find another employee
        final String anotherSearchName = "John"; // Use final for another search
        employeeOptional = findEmployeeByName(anotherSearchName);

        employeeOptional.ifPresentOrElse(
            employee -> System.out.println("Found employee: " + employee),
            () -> System.out.println("Employee with name '" + anotherSearchName + "' not found.")
        );
    }

    public static void main(String[] args) {
        EmployeeExample example = new EmployeeExample();
        example.runExamples();
    }
}

/*

Explanation:
Employee Class: Represents an employee with properties like name, age, gender, and department. It includes getters and a toString method for displaying the employee details.

getEmployees() Method: Returns a predefined list of Employee objects.

countEmployeesByGender() Method: Counts the number of male and female employees using the Stream API and returns a Map<Gender, Long>.

runExamples() Method: Demonstrates various Stream operations:

Counting employees by gender.
Filtering employees by department.
Calculating the average age of employees.
Listing all unique departments.
Main Method: Executes the examples.

*/
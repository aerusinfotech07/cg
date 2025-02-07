package com.cg.java8.scenarios.employees;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

enum EmpGender {
    MALE, FEMALE
}

class Employee {
    private String name;
    private int age;    
    private String department;
    private EmpGender gender;
    private double salary;

  

    public Employee(String name, int age, String department, EmpGender gender,double salary) {
		super();
		this.name = name;
		this.age = age;
		this.department = department;
		this.gender = gender;
		this.salary=salary;
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
    
    

    public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setGender(EmpGender gender) {
		this.gender = gender;
	}

	@Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", gender=" + gender + ", department='" + department + "'}";
    }

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}

public class EmployeeExample {
	
	public static void main(String args[])
	{
		List<Employee> empList=Arrays.asList(
				new Employee("Alice", 30, "HR", EmpGender.FEMALE,30000),
				new Employee("Alice1", 32, "HR", EmpGender.FEMALE,567777),
				new Employee("Alice2", 35, "HR", EmpGender.FEMALE,66777),
                new Employee("Bob", 25, "IT", EmpGender.MALE,45666),
                new Employee("Bob1", 27, "IT", EmpGender.FEMALE,32000),
                new Employee("Bob2", 22, "IT", EmpGender.MALE,45000),
                new Employee("Charlie", 28, "Finance", EmpGender.MALE,60000),
                new Employee("Charlie1", 25, "Finance", EmpGender.MALE,56000),
                new Employee("Charlie2", 22, "Finance", EmpGender.MALE,23000)
              );
		
		
		long countMale=empList.stream()
		.filter(e->e.getGender()==EmpGender.MALE)
		.count();
		
		long countFemale=empList.stream()
				.filter(e->e.getGender()==EmpGender.MALE)
				.count();
		
		
		empList.stream()
		.collect(
				Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
		.forEach((k,v)->{
			System.out.println(k+" "+v);
		});
		
		empList.stream()
		.collect(
				Collectors.groupingBy(Employee::getDepartment,Collectors.counting())
				).forEach((k,v)->{
					System.out.println();
				});
		
		empList.stream()
		.collect(
				Collectors
				.groupingBy(Employee::getGender,
						Collectors.summingDouble(Employee::getSalary))
				).forEach((k,v)->{
					System.out.println();
				});
		
		
		
		
	}
	
	

    private List<Employee> getEmployees() {
        return List.of(
               
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
        
        Map<String,Long> mapValue=employeeList.stream()
        		.collect(Collectors.groupingBy(
        				Employee::getDepartment,Collectors.counting()));
        
        
        
        
        
        
        
        
        employeeList.stream().sorted(Comparator.comparing(Employee::getName).reversed());
        

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
                .sorted()
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
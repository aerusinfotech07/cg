package com.cg.springapp.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cg.springapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	 List<Employee> findByFirstName(String firstName);
	List<Employee> findByFirstNameAndLastName(String firstName,String lastName);
	List<Employee> findByAgeGreaterThan(int age);
	List<Employee> findByAgeBetween(int start,int end);
	
	
}

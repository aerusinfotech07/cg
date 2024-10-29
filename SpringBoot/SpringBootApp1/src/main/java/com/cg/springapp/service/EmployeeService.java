package com.cg.springapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springapp.dao.EmployeeRepository;
import com.cg.springapp.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> findById(Integer id) {
		return employeeRepository.findById(id);
	}

	public Employee getById(Integer id) {
		return employeeRepository.getById(id);
	}

	List<Employee> findByFirstName(String firstName) {
		return employeeRepository.findByFirstName(firstName);
	}

	List<Employee> findByFirstNameAndLastName(String firstName, String lastName) {
		return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	List<Employee> findByAgeGreaterThan(int age) {
		return employeeRepository.findByAgeGreaterThan(age);
	}

	List<Employee> findByAgeBetween(int start, int end) {
		return employeeRepository.findByAgeBetween(start, end);
	}
	
	public Employee save(Employee emp)
	{
		return employeeRepository.save(emp);
	}
	
	public boolean deleteEmp(Integer id)
	{
		Optional<Employee> emp=findById(id);
		if(emp.isPresent()) {
			employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}

}

package com.cg.springapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cg.springapp.model.Employee;
import com.cg.springapp.service.EmployeeService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	@GetMapping("/emp")
	public Employee emp() {
		Optional<Employee> emp=service.findById(101);
		if(emp.isPresent())
			return emp.get();
		else
			return null;
	}
	
	
	@GetMapping("/empList")
	public List<Employee> empList() {
		
		return service.findAll();
	}
	
	
	
}

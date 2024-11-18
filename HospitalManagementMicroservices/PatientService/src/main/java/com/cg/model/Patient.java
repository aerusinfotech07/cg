package com.cg.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;


@Data

public class Patient {
	
	
	private int id;
	private String firstName;
	private String lastName;
	private String dob;
	private int age;
	private String address;
	
	    private Set<Appointment> appointments = new HashSet<>();
	

}

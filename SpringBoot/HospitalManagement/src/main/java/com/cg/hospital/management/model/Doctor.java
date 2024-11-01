package com.cg.hospital.management.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Doctor {
	
	private int id;
	private String firstName;
	private String lastName;
	private String dob;
	private int age;
	private String address;
	

}

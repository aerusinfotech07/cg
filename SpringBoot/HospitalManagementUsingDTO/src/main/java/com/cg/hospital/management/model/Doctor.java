package com.cg.hospital.management.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String dob;
	private int age;
	private String address;
	
	 @ManyToMany
	    @JoinTable(
	        name = "doctor_appointment",
	        joinColumns = @JoinColumn(name = "doctor_id"),
	        inverseJoinColumns = @JoinColumn(name = "appointment_id")
	    )
	    private Set<Appointment> appointments = new HashSet<>();
	 
	

}

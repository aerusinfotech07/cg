package com.cg.hospital.management.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "FIRST_NAME",length = 20)
	private String firstName;
	private String lastName;
	private String dob;
	private int age;
	private String address;
	
	
	  @ManyToMany
	    @JoinTable(
	        name = "patient_appointment",
	        joinColumns = @JoinColumn(name = "patient_id"),
	        inverseJoinColumns = @JoinColumn(name = "appointment_id")
	    )
	    private Set<Appointment> appointments = new HashSet<>();
	

}

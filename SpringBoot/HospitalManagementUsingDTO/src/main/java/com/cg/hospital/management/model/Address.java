package com.cg.hospital.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String area;
	private String pinCode;
	private String country;
	private String state;
	
	//For Step1
	/*@ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
	*/


}

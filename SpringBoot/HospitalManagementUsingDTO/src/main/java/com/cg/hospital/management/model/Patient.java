package com.cg.hospital.management.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	
	//Step1:-If you want to achive bidirectional
	/*@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> address;
    //Same relation must be in Address class Also
	*/
	
	//Step2
	/*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "patient_id") // This creates a foreign key column in the Address table
    private List<Address> address;
    //This is maintain PatientId as reference key in address table
	*/
	
	//Step3
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
        name = "patient_address",
        joinColumns = @JoinColumn(name = "patient_id"),
        inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<Address> address;
	//This would create third table where it will maintain mapping of patient with address 
	 
	 
	
	  @ManyToMany
	    @JoinTable(
	        name = "patient_appointment",
	        joinColumns = @JoinColumn(name = "patient_id"),
	        inverseJoinColumns = @JoinColumn(name = "appointment_id")
	    )
	    private Set<Appointment> appointments = new HashSet<>();
	

}

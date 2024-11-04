package com.cg.hospital.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hospital.management.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

	List<Patient> findByFirstNameContaining(String firstName);
	List<Patient> findByFirstNameContainingAndLastNameContaining(String firstName,String lastName);
	List<Patient> findByFirstNameContainingAndAgeGreaterThan(String firstName,int age);
	
	
}

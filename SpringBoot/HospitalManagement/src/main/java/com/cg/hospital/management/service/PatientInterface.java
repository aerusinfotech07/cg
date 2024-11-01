package com.cg.hospital.management.service;

import java.util.List;

import com.cg.hospital.management.model.Patient;

public interface PatientInterface {
	
	List<Patient> findAll();
	Patient findById(Integer id);
	Patient save(Patient patient);
	Patient update(Integer id,Patient patient);
	boolean delete(Integer id);
	boolean delete(Patient patient);
}

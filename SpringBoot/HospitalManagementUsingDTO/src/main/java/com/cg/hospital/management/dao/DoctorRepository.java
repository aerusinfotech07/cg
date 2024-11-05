package com.cg.hospital.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hospital.management.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>
{
	
}

package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer>{

}

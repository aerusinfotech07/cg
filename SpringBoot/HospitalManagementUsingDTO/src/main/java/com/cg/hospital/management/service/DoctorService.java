package com.cg.hospital.management.service;

import java.util.List;

import com.cg.hospital.management.dto.DoctorDTO;

public interface DoctorService {
	
	DoctorDTO save(DoctorDTO doctorDTO);
	List<DoctorDTO> findAll();
	DoctorDTO findById(Integer doctorId);
	DoctorDTO update(Integer doctorId,DoctorDTO doctorDTO);
	boolean delete(Integer doctorId);
	
	
	

}

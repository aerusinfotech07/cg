package com.cg.hospital.management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hospital.management.dao.DoctorRepository;
import com.cg.hospital.management.dto.DoctorDTO;
import com.cg.hospital.management.dto.PatientDto;
import com.cg.hospital.management.model.Doctor;
import com.cg.hospital.management.model.Patient;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository doctorRepository;
	
	@Override
	public DoctorDTO save(DoctorDTO doctorDTO) {
		Doctor doctor=convertDTOToEntity(doctorDTO);
		doctor=doctorRepository.save(doctor);
		doctorDTO=convertEntityToDTO(doctor);
		return doctorDTO;
	}

	@Override
	public List<DoctorDTO> findAll() {
	
		return doctorRepository.findAll().stream().map(this::convertEntityToDTO).toList();
	}

	@Override
	public DoctorDTO findById(Integer doctorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoctorDTO update(Integer doctorId, DoctorDTO doctorDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer doctorId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	DoctorDTO convertEntityToDTO(Doctor doctor)
	{
		DoctorDTO doctorDTO=new DoctorDTO();
		doctorDTO.setFirstName(doctor.getFirstName());
		/////
		
		
		return doctorDTO;
		
	}
	
	
	Doctor convertDTOToEntity(DoctorDTO doctorDTO)
	{
		Doctor doctor=new Doctor();
		doctor.setFirstName(doctorDTO.getFirstName());
		/////
		
		
		return doctor;		
	}
	

}

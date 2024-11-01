package com.cg.hospital.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hospital.management.dao.PatientRepository;
import com.cg.hospital.management.model.Patient;

@Service
public class PatientInterfaceImpl implements PatientInterface{
	
	@Autowired
	PatientRepository patientRepository;

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Override
	public Patient findById(Integer id) {
		Optional<Patient> optional=patientRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public Patient save(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	@Override
	public Patient update(Integer id, Patient patient) {
		Patient patientTemp=findById(id);
		if(patientTemp!=null)
		{
			if(patient.getFirstName()!=null && !patient.getFirstName().isEmpty())
				patientTemp.setFirstName(patient.getFirstName());
			
			if(patient.getLastName()!=null && !patient.getLastName().isEmpty())
				patientTemp.setLastName(patient.getLastName());
			
			if(patient.getDob()!=null && !patient.getDob().isEmpty())
				patientTemp.setDob(patient.getDob());
			
			if(patient.getAddress()!=null && !patient.getAddress().isEmpty())
				patientTemp.setAddress(patient.getAddress());
			
			if(patient.getAge()!=0)
				patientTemp.setAge(patient.getAge());
			
			
			return patientRepository.save(patientTemp);
			
			
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		Optional<Patient> optional=patientRepository.findById(id);
		if(optional.isPresent())
		{
			patientRepository.deleteById(id);
			return true;
		}
		else
		return false;
	}

	@Override
	public boolean delete(Patient patient) {
		Optional<Patient> optional=patientRepository.findById(patient.getId());
		if(optional.isPresent())
		{
			patientRepository.delete(optional.get());
			return true;
		}
		else
		return false;
	}

}

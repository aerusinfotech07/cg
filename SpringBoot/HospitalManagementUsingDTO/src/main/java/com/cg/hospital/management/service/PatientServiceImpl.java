package com.cg.hospital.management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hospital.management.dao.PatientRepository;
import com.cg.hospital.management.dto.PatientDto;
import com.cg.hospital.management.exception.PatientNotFoundException;
import com.cg.hospital.management.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientDto createPatient(PatientDto patientDTO) {
        Patient patient = new Patient();
        // Map DTO to entity
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setDob(patientDTO.getDob());
        patient.setAge(patientDTO.getAge());
        patient.setAddress(patientDTO.getAddress());

        patient = patientRepository.save(patient);

        // Map entity to DTO
        patientDTO.setId(patient.getId());
        return patientDTO;
    }

    @Override
    public PatientDto getPatientById(int id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id " + id));
        return mapToDTO(patient);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        return patientRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public PatientDto updatePatient(int id, PatientDto patientDTO) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id " + id));
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setDob(patientDTO.getDob());
        patient.setAge(patientDTO.getAge());
        patient.setAddress(patientDTO.getAddress());
        patient = patientRepository.save(patient);
        return mapToDTO(patient);
    }

    @Override
    public void deletePatient(int id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id " + id));
        patientRepository.delete(patient);
    }

    private PatientDto mapToDTO(Patient patient) {
        PatientDto patientDTO = new PatientDto();
        patientDTO.setId(patient.getId());
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setLastName(patient.getLastName());
        patientDTO.setDob(patient.getDob());
        patientDTO.setAge(patient.getAge());
        patientDTO.setAddress(patient.getAddress());
        return patientDTO;
    }
}

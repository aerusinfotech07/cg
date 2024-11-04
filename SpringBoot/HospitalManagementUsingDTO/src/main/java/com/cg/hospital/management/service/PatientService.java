package com.cg.hospital.management.service;

import java.util.List;

import com.cg.hospital.management.dto.PatientDto;

public interface PatientService {
    PatientDto createPatient(PatientDto patientDTO);
    PatientDto getPatientById(int id);
    List<PatientDto> getAllPatients();
    PatientDto updatePatient(int id, PatientDto patientDTO);
    void deletePatient(int id);
}

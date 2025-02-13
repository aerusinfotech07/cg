package com.cg.hospital.management.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.hospital.management.dao.PatientRepository;
import com.cg.hospital.management.dto.PatientDto;
import com.cg.hospital.management.exception.PatientNotFoundException;
import com.cg.hospital.management.model.Patient;

@SpringBootTest
public class PatientServiceImplTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientServiceImpl patientService;

    private Patient patient;
    private PatientDto patientDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        // Initialize sample data
        patient = new Patient();
        patient.setId(1);
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setDob("1990-01-01");
        patient.setAge(32);
        patient.setAddress(new ArrayList<>());

        patientDTO = new PatientDto();
        patientDTO.setFirstName("John");
        patientDTO.setLastName("Doe");
        patientDTO.setDob("1990-01-01");
        patientDTO.setAge(32);
        patientDTO.setAddress(new ArrayList<>());
    }

    @Test
    void createPatient_ShouldReturnSavedPatientDto() {
        when(patientRepository.save(any(Patient.class))).thenReturn(patient);

        PatientDto result = patientService.createPatient(patientDTO);

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        verify(patientRepository, times(1)).save(any(Patient.class));
    }

    @Test
    void getPatientById_ShouldReturnPatientDto_WhenPatientExists() {
        when(patientRepository.findById(1)).thenReturn(Optional.of(patient));

        PatientDto result = patientService.getPatientById(1);

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        //verify(patientRepository, times(1)).findById(1);
    }

    @Test
    void getPatientById_ShouldThrowException_WhenPatientDoesNotExist() {
        when(patientRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(PatientNotFoundException.class, () -> patientService.getPatientById(1));
        verify(patientRepository, times(1)).findById(1);
    }
}

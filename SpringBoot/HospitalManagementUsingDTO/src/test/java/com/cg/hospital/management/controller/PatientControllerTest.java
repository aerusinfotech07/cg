package com.cg.hospital.management.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.hospital.management.dto.PatientDto;
import com.cg.hospital.management.service.PatientService;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {

    @MockBean
    private PatientService patientService;

    @InjectMocks
    private PatientController patientController;

    private MockMvc mockMvc;

    private PatientDto patientDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();

        patientDTO = new PatientDto();
        patientDTO.setId(1);
        patientDTO.setFirstName("John");
        patientDTO.setLastName("Doe");
        patientDTO.setDob("1990-01-01");
        patientDTO.setAge(32);
        //patientDTO.setAddress("123 Main St");
    }

    @Test
    void getPatientById_ShouldReturnPatientDto() throws Exception {
        when(patientService.getPatientById(1)).thenReturn(patientDTO);

        mockMvc.perform(get("/api/patients/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"));

        verify(patientService, times(1)).getPatientById(1);
    }

    @Test
    void createPatient_ShouldReturnCreatedPatientDto() throws Exception {
        when(patientService.createPatient(any(PatientDto.class))).thenReturn(patientDTO);

        mockMvc.perform(post("/api/patients")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\":\"John\", \"lastName\":\"Doe\", \"dob\":\"1990-01-01\", \"age\":32, \"address\":\"123 Main St\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("John"));

        verify(patientService, times(1)).createPatient(any(PatientDto.class));
    }

    @Test
    void getAllPatients_ShouldReturnListOfPatients() throws Exception {
        List<PatientDto> patients = Arrays.asList(patientDTO);
        when(patientService.getAllPatients()).thenReturn(patients);

        mockMvc.perform(get("/api/patients")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("John"));

        verify(patientService, times(1)).getAllPatients();
    }
}


package com.cg.hospital.management.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.hospital.management.dto.PatientAppointmentDTO;
import com.cg.hospital.management.dto.PatientDto;
import com.cg.hospital.management.service.AppointmentService;
import com.cg.hospital.management.service.PatientService;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {

    @MockBean
    private PatientService patientService;

    @MockBean
    private AppointmentService appointmentService;

    @InjectMocks
    private PatientController patientController;

    private MockMvc mockMvc;

    private PatientDto patientDTO;
    private PatientAppointmentDTO appointmentDTO;

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
        patientDTO.setAddress("123 Main St");

        appointmentDTO = new PatientAppointmentDTO();
        appointmentDTO.setAppointmentId(1);
        appointmentDTO.setPatientId(1);
        appointmentDTO.setDoctorFirstName("Dr. Smith");
        try {
            appointmentDTO.setAppointmentDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-11-07"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    void createPatient_ShouldReturnCreatedPatientDto() throws Exception {
        when(patientService.createPatient(any(PatientDto.class))).thenReturn(patientDTO);

        mockMvc.perform(post("/api/patients")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\":\"John\", \"lastName\":\"Doe\", \"dob\":\"1990-01-01\", \"age\":32, \"address\":\"123 Main St\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe1"))
                ;

        verify(patientService, times(1)).createPatient(any(PatientDto.class));
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
    void getAllPatients_ShouldReturnListOfPatients() throws Exception {
        List<PatientDto> patients = Arrays.asList(patientDTO);
        when(patientService.getAllPatients()).thenReturn(patients);

        mockMvc.perform(get("/api/patients")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("John"));

        verify(patientService, times(1)).getAllPatients();
    }

    @Test
    void updatePatient_ShouldReturnUpdatedPatientDto() throws Exception {
        when(patientService.updatePatient(eq(1), any(PatientDto.class))).thenReturn(patientDTO);

        mockMvc.perform(put("/api/patients/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\":\"John\", \"lastName\":\"Doe\", \"dob\":\"1990-01-01\", \"age\":32, \"address\":\"123 Main St\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"));

        verify(patientService, times(1)).updatePatient(eq(1), any(PatientDto.class));
    }

    @Test
    void deletePatient_ShouldReturnNoContentStatus() throws Exception {
        mockMvc.perform(delete("/api/patients/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(patientService, times(1)).deletePatient(1);
    }

    @Test
    void getAppointmentsByPatientId_ShouldReturnListOfAppointments() throws Exception {
        List<PatientAppointmentDTO> appointments = Arrays.asList(appointmentDTO);
        when(appointmentService.getAppointmentsByPatientId(1)).thenReturn(appointments);

        mockMvc.perform(get("/api/patients/1/appointments")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].doctorFirstName").value("Dr. Smith"));

        verify(appointmentService, times(1)).getAppointmentsByPatientId(1);
    }
}

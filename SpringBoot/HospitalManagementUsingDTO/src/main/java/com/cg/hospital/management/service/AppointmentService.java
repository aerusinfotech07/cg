package com.cg.hospital.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hospital.management.dao.AppointmentRepository;
import com.cg.hospital.management.dao.DoctorRepository;
import com.cg.hospital.management.dao.PatientRepository;
import com.cg.hospital.management.dto.PatientAppointmentDTO;
import com.cg.hospital.management.model.Appointment;
import com.cg.hospital.management.model.Doctor;
import com.cg.hospital.management.model.Patient;


public interface AppointmentService {   

    public Appointment createAppointment(int patientId, int doctorId, Appointment appointment);
   
    public List<PatientAppointmentDTO> getAppointmentsByPatientId(int patientId);
    
}

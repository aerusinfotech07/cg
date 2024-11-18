package com.cg.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.AppointmentRepository;
import com.cg.dto.DoctorDTO;
import com.cg.dto.PatientDTO;
import com.cg.fiegn.DoctorClient;
import com.cg.fiegn.PatientClient;
import com.cg.model.Appointment;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorClient doctorClient;

    @Autowired
    private PatientClient patientClient;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(int id) {
        return appointmentRepository.findById(id);
    }

    public Appointment saveAppointment(Appointment appointment) {
        // You may want to add validation logic here to verify doctor and patient exist
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(int id, Appointment appointmentDetails) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
        appointment.setFees(appointmentDetails.getFees());
        appointment.setStatus(appointmentDetails.getStatus());
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(int id) {
        appointmentRepository.deleteById(id);
    }

    public DoctorDTO getDoctorById(int doctorId) {
        return doctorClient.getDoctorById(doctorId);
    }

    public PatientDTO getPatientById(int patientId) {
        return patientClient.getPatientById(patientId);
    }
}


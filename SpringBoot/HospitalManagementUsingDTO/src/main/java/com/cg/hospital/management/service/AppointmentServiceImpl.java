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

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public Appointment createAppointment(int patientId, int doctorId, Appointment appointment) {
        Optional<Patient> patientOpt = patientRepository.findById(patientId);
        Optional<Doctor> doctorOpt = doctorRepository.findById(doctorId);

        if (patientOpt.isPresent() && doctorOpt.isPresent()) {
            Patient patient = patientOpt.get();
            Doctor doctor = doctorOpt.get();

            appointment.getPatients().add(patient);
            appointment.getDoctors().add(doctor);

            return appointmentRepository.save(appointment);
        } else {
            throw new RuntimeException("Patient or Doctor not found");
        }
    }
   
    public List<PatientAppointmentDTO> getAppointmentsByPatientId(int patientId) {
        return appointmentRepository.findAppointmentsByPatientId(patientId);
    }
    
}

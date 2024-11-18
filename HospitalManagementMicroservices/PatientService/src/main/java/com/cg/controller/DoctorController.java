package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.DoctorRepository;
import com.cg.fiegn.AppointmentClient;
import com.cg.model.Appointment;
import com.cg.model.Doctor;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	
	@Autowired
    private  DoctorRepository doctorRepository;
	@Autowired
    private  AppointmentClient appointmentClient;

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable int id) {
        return doctorRepository.findById(id).orElseThrow();
    }

    @GetMapping("/{doctorId}/appointments")
    public List<Appointment> getDoctorAppointments(@PathVariable int doctorId) {
        return appointmentClient.getAppointmentsForDoctor(doctorId);
    }
}
package com.cg.hospital.management.controller;

import com.cg.hospital.management.model.Appointment;
import com.cg.hospital.management.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/{patientId}/{doctorId}")
    public Appointment createAppointment(
            @PathVariable int patientId,
            @PathVariable int doctorId,
            @RequestBody Appointment appointment) {
        return appointmentService.createAppointment(patientId, doctorId, appointment);
    }
}

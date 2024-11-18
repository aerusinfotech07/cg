package com.cg.fiegn;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.model.Appointment;

@FeignClient(name = "appointment-service")
public interface AppointmentClient {
    @GetMapping("/appointments/{doctorId}")
    List<Appointment> getAppointmentsForDoctor(@PathVariable int doctorId);
}

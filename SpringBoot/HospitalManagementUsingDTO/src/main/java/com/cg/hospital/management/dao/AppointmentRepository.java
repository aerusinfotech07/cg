package com.cg.hospital.management.dao;

import com.cg.hospital.management.dto.PatientAppointmentDTO;
import com.cg.hospital.management.model.Appointment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
	 @Query("SELECT new com.cg.hospital.management.dto.PatientAppointmentDTO(" +
	           "p.id, p.firstName, p.lastName, " +
	           "d.id, d.firstName, d.lastName, " +
	           "a.appointmentId, a.appointmentDate, a.fees, a.status) " +
	           "FROM Appointment a " +
	           "JOIN a.patients p " +
	           "JOIN a.doctors d " +
	           "WHERE p.id = :patientId")
	    List<PatientAppointmentDTO> findAppointmentsByPatientId(int patientId);
}

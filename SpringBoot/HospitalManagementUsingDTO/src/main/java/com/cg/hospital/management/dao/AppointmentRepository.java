package com.cg.hospital.management.dao;

import com.cg.hospital.management.dto.PatientAppointmentDTO;
import com.cg.hospital.management.model.Appointment;
import com.cg.hospital.management.model.StatusEnum;

import java.util.Date;
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
	 
	 
	 
	// 1. Find all appointments by status
	    List<Appointment> findByStatus(StatusEnum status);

	    // JPQL query for the same purpose
	    @Query("SELECT a FROM Appointment a WHERE a.status = :status")
	    List<Appointment> findAppointmentsByStatus(StatusEnum status);

	    // 2. Find all appointments on a specific date
	    List<Appointment> findByAppointmentDate(Date appointmentDate);

	    @Query("SELECT a FROM Appointment a WHERE a.appointmentDate = :appointmentDate")
	    List<Appointment> findAppointmentsByDate(Date appointmentDate);

	    // 3. Find appointments with fees greater than a specific amount
	    List<Appointment> findByFeesGreaterThan(double fees);

	    @Query("SELECT a FROM Appointment a WHERE a.fees > :fees")
	    List<Appointment> findAppointmentsWithFeesGreaterThan(double fees);

	    // 4. Find appointments by patient ID
	    @Query("SELECT a FROM Appointment a JOIN a.patients p WHERE p.id = :patientId")
	    List<Appointment> findAppointmentsByPatientIdNew(int patientId);

	    // 5. Find appointments by patient last name
	    @Query("SELECT a FROM Appointment a JOIN a.patients p WHERE p.lastName = :lastName")
	    List<Appointment> findAppointmentsByPatientLastName(String lastName);

	    // 6. Find appointments within a date range
	    @Query("SELECT a FROM Appointment a WHERE a.appointmentDate BETWEEN :startDate AND :endDate")
	    List<Appointment> findAppointmentsBetweenDates(Date startDate, Date endDate);

	    // 7. Find appointments by status and fees greater than a specified amount
	    @Query("SELECT a FROM Appointment a WHERE a.status = :status AND a.fees > :fees")
	    List<Appointment> findAppointmentsByStatusAndFeesGreaterThan(StatusEnum status, double fees);
	}

package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

}

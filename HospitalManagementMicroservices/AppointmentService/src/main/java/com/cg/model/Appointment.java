package com.cg.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    @Temporal(TemporalType.DATE)
    private Date appointmentDate;

    private double fees;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private int doctorId; // References a doctor in DoctorService
    private int patientId; // References a patient in PatientService

    // Getters and setters
}

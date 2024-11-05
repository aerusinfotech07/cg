package com.cg.hospital.management.dto;

import java.util.Date;
import java.util.Set;

import com.cg.hospital.management.model.Appointment;
import com.cg.hospital.management.model.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientAppointmentDTO {
    
    private int patientId;
    private String patientFirstName;
    private String patientLastName;
    
    private int doctorId;
    private String doctorFirstName;
    private String doctorLastName;
    
    private int appointmentId;
    private Date appointmentDate;
    private double fees;
    private StatusEnum status;
    
}

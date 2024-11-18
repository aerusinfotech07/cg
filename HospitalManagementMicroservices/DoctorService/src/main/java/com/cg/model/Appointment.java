package com.cg.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Appointment {
	
	private int appointmentId;
	
	 private Date appointmentDate;
	    
	    private double fees;

	    private StatusEnum status;
	    
	    private Set<Patient> patients = new HashSet<>();

	    private Set<Doctor> doctors = new HashSet<>();

}

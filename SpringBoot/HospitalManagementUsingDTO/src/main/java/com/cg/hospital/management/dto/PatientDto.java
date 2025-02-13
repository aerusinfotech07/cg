package com.cg.hospital.management.dto;

import java.util.List;

import com.cg.hospital.management.model.Address;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PatientDto {

    private int id;

    @NotBlank(message = "First name is required.")
    private String firstName;

    @NotBlank(message = "Last name is required.")
    private String lastName;

    @NotBlank(message = "Date of birth is required.")
    private String dob;

    @Min(value = 18, message = "Age must be more than 18.")
    @Max(value = 60, message = "Age must be below 60.")
    private int age;

    private List<Address> address;

	
    
}

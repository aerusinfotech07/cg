package com.cg.hospital.management.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
public class DoctorDTO {
	
	private int id;
	@NotBlank(message = "FirstName Should not be Empty")
	private String firstName;
	@NotBlank(message = "Last Name Should not be Blank")
	private String lastName;
	private String dob;
	@Min(value = 16)
	@Max(value = 60)
	private int age;
	private String address;
	

}

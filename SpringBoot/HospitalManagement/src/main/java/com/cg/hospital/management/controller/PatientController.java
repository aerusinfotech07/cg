package com.cg.hospital.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hospital.management.model.Patient;
import com.cg.hospital.management.service.PatientInterface;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/patients")
public class PatientController {

	@Autowired
	PatientInterface patientInterface;
	
	@GetMapping
	public ResponseEntity<List<Patient>> getAllPatients()
	{
		if(patientInterface.findAll().isEmpty())
			return  new ResponseEntity<>(patientInterface.findAll(),HttpStatus.OK);
			else
		return  new ResponseEntity<>(patientInterface.findAll(),HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public Patient savePatient(@RequestBody Patient patient)
	{
		return patientInterface.save(patient);
		
	}
	
	@GetMapping("findById")
	public ResponseEntity<Patient> findById(@RequestParam(name = "id") Integer id,@RequestParam(name = "name") String name) {
		
		Patient patient=patientInterface.findById(id);
		if(patient!=null)
		return new ResponseEntity<>(patientInterface.findById(id),HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	

	@GetMapping("findByIdUsingPathVariable/{id}/{name}")
	public ResponseEntity<Patient> findByIdUsingPathVariable(@PathVariable(name="id") Integer id,@PathVariable(name = "name") String name) {
		
		Patient patient=patientInterface.findById(id);
		if(patient!=null)
		return new ResponseEntity<>(patientInterface.findById(id),HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("searchPatient")
	public ResponseEntity<Patient> searchPatient(@RequestBody Patient patient)
	{
		Patient patientTemp=patientInterface.findById(patient.getId());
		if(patientTemp!=null)
		return new ResponseEntity<>(patientTemp,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Patient> deleteById(@PathVariable(name = "id") Integer id) {
		
		Patient patient=patientInterface.findById(id);
		if(patient!=null)
		{
			patientInterface.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

	@PutMapping("{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Integer id,@RequestBody Patient patient)
	{
		Patient temp=patientInterface.update(id, patient);
		if(temp==null)
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(temp,HttpStatus.OK);
	}	
}

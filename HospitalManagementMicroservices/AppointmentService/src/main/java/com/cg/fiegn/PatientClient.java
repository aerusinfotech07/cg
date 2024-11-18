package com.cg.fiegn;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.dto.PatientDTO;

@FeignClient(name = "patient-service") // Replace with the actual name in service registry
public interface PatientClient {

    @GetMapping("/patients/{id}")
    PatientDTO getPatientById(@PathVariable("id") int id);
    
   
}

package com.cg.fiegn;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.dto.DoctorDTO;

@FeignClient(value = "doctorClient",url = "") // Replace with the actual name in service registry
public interface DoctorClient {

    @GetMapping("/doctors/{id}")
    DoctorDTO getDoctorById(@PathVariable("id") int id);
}


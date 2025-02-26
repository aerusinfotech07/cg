package com.cg.hospital.management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hospital.management.dto.DoctorDTO;
import com.cg.hospital.management.service.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> save(@Valid  @RequestBody DoctorDTO doctorDTO) {
        DoctorDTO savedDoctor = doctorService.save(doctorDTO);
        return ResponseEntity.ok(savedDoctor);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> findAll() {
        List<DoctorDTO> doctors = doctorService.findAll();
        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDTO> findById(@PathVariable Integer doctorId) {
        DoctorDTO doctor = doctorService.findById(doctorId);
        return ResponseEntity.ok(doctor);
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<DoctorDTO> update(@PathVariable Integer doctorId, @RequestBody DoctorDTO doctorDTO) {
        DoctorDTO updatedDoctor = doctorService.update(doctorId, doctorDTO);
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<Void> delete(@PathVariable Integer doctorId) {
        boolean deleted = doctorService.delete(doctorId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}


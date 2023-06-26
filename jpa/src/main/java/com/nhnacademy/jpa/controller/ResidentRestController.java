package com.nhnacademy.jpa.controller;

import com.nhnacademy.jpa.dto.resident.ResidentDto;
import com.nhnacademy.jpa.dto.resident.ResidentRegisterRequest;
import com.nhnacademy.jpa.dto.resident.ResidentUpdateRequest;
import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/residents")
public class ResidentRestController {

    private final ResidentService residentService;

    public ResidentRestController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity<ResidentDto> getResident(@PathVariable Long serialNumber) {
        ResidentDto dto = residentService.getResident(serialNumber);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Resident> registerResident(@RequestBody ResidentRegisterRequest residentRegisterRequest) {
        Resident resident = residentService.registerResident(residentRegisterRequest);
        return new ResponseEntity<>(resident, HttpStatus.CREATED);
    }

    @PutMapping("/{serialNumber}")
    public ResponseEntity<ResidentDto> modifyResident(@PathVariable Long serialNumber,
                                                      @RequestBody ResidentUpdateRequest residentUpdateRequest) {
        ResidentDto dto = residentService.modifyResident(serialNumber, residentUpdateRequest);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{serialNumber}")
    public ResponseEntity<Void> deleteResident(@PathVariable Long serialNumber) {
        residentService.deleteResident(serialNumber);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/resident?page=0?&size=5")).build();
    }
}
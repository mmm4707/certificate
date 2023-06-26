package com.nhnacademy.jpa.controller;

import com.nhnacademy.jpa.dto.household.HouseholdDto;
import com.nhnacademy.jpa.dto.household.HouseholdRegisterRequest;
import com.nhnacademy.jpa.service.HouseholdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/household")
public class HouseholdController {

    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @PostMapping
    public ResponseEntity<HouseholdDto> registerHousehold(@RequestBody HouseholdRegisterRequest request) {
        HouseholdDto householdDto = householdService.registerHousehold(request);
        return new ResponseEntity<>(householdDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{householdSerialNumber}")
    public ResponseEntity<Void> deleteHousehold(@PathVariable Long householdSerialNumber) {
        householdService.deleteHousehold(householdSerialNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
package com.nhnacademy.jpa.controller;

import com.nhnacademy.jpa.dto.householdAddress.HouseholdMovementAddressDto;
import com.nhnacademy.jpa.dto.householdAddress.HouseholdMovementRegisterRequest;
import com.nhnacademy.jpa.dto.householdAddress.HouseholdMovementUpdateRequest;
import com.nhnacademy.jpa.service.HouseholdMovementAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/household/{householdSerialNumber}/movement")
public class HouseholdMovementAddressController {

    private final HouseholdMovementAddressService householdMovementAddressService;

    public HouseholdMovementAddressController(HouseholdMovementAddressService householdMovementAddressService) {
        this.householdMovementAddressService = householdMovementAddressService;
    }

    @PostMapping
    public ResponseEntity<HouseholdMovementAddressDto> registerHouseholdAddress(@PathVariable Long householdSerialNumber,
                                                                                @RequestBody HouseholdMovementRegisterRequest request) {
        HouseholdMovementAddressDto dto = householdMovementAddressService.registerAddress(householdSerialNumber, request);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("/{reportDate}")
    public ResponseEntity<HouseholdMovementAddressDto> modifyHouseholdAddress(@PathVariable Long householdSerialNumber,
                                                                              @PathVariable String reportDate,
                                                                              @RequestBody HouseholdMovementUpdateRequest request) throws ParseException {
        HouseholdMovementAddressDto dto = householdMovementAddressService.modifyAddress(householdSerialNumber, reportDate, request);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{reportDate}")
    public ResponseEntity<Void> deleteHouseholdAddress(@PathVariable Long householdSerialNumber,
                                                       @PathVariable String reportDate) throws ParseException {
        householdMovementAddressService.deleteAddress(householdSerialNumber, reportDate);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
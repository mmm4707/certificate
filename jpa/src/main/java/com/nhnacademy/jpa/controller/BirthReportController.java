package com.nhnacademy.jpa.controller;

import com.nhnacademy.jpa.dto.birthDeathReportResident.BirthDeathReportDto;
import com.nhnacademy.jpa.dto.birthDeathReportResident.BirthReportRegisterRequest;
import com.nhnacademy.jpa.dto.birthDeathReportResident.BirthReportUpdateRequest;
import com.nhnacademy.jpa.service.BirthDeathReportResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residents")
public class BirthReportController {

    private final BirthDeathReportResidentService birthDeathReportResidentService;

    public BirthReportController(BirthDeathReportResidentService birthDeathReportResidentService) {
        this.birthDeathReportResidentService = birthDeathReportResidentService;
    }

    @PostMapping("/{serialNumber}/birth")
    public ResponseEntity<BirthDeathReportDto> registerBirthReport(@PathVariable Long serialNumber,
                                                                   @RequestBody BirthReportRegisterRequest request) {
        BirthDeathReportDto birthDeathReportDto = birthDeathReportResidentService.registerBirthReport(serialNumber, request);
        return new ResponseEntity<>(birthDeathReportDto, HttpStatus.CREATED);
    }

    @PutMapping("/{serialNumber}/birth/{targetSerialNumber}")
    public ResponseEntity<BirthDeathReportDto> modifyBirthReport(@PathVariable Long serialNumber,
                                                                 @PathVariable Long targetSerialNumber,
                                                                 @RequestBody BirthReportUpdateRequest request) {
        BirthDeathReportDto birthDeathReportDto = birthDeathReportResidentService.modifyBirthReport(serialNumber, targetSerialNumber, request);
        return new ResponseEntity<>(birthDeathReportDto, HttpStatus.OK);
    }

    @DeleteMapping("/{serialNumber}/birth/{targetSerialNumber}")
    public ResponseEntity<Void> deleteBirthReport(@PathVariable Long serialNumber,
                                                  @PathVariable Long targetSerialNumber) {
        birthDeathReportResidentService.deleteBirthDeathReport(serialNumber, targetSerialNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
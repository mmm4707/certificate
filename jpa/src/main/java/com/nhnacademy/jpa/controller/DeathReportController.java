package com.nhnacademy.jpa.controller;

import com.nhnacademy.jpa.dto.birthDeathReportResident.BirthDeathReportDto;
import com.nhnacademy.jpa.dto.birthDeathReportResident.DeathReportRegisterRequest;
import com.nhnacademy.jpa.dto.birthDeathReportResident.DeathReportUpdateRequest;
import com.nhnacademy.jpa.service.BirthDeathReportResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residents")
public class DeathReportController {

    private final BirthDeathReportResidentService birthDeathReportResidentService;

    public DeathReportController(BirthDeathReportResidentService birthDeathReportResidentService) {
        this.birthDeathReportResidentService = birthDeathReportResidentService;
    }

    @PostMapping("/{serialNumber}/death")
    public ResponseEntity<BirthDeathReportDto> registerDeathReport(@PathVariable Long serialNumber,
                                                                   @RequestBody DeathReportRegisterRequest request) {
        BirthDeathReportDto birthDeathReportDto = birthDeathReportResidentService.registerDeathReport(serialNumber, request);
        return new ResponseEntity<>(birthDeathReportDto, HttpStatus.CREATED);
    }

    @PutMapping("/{serialNumber}/death/{targetSerialNumber}")
    public ResponseEntity<BirthDeathReportDto> modifyDeathReport(@PathVariable Long serialNumber,
                                                                 @PathVariable Long targetSerialNumber,
                                                                 @RequestBody DeathReportUpdateRequest request) {
        BirthDeathReportDto birthDeathReportDto = birthDeathReportResidentService.modifyDeathReport(serialNumber, targetSerialNumber, request);
        return new ResponseEntity<>(birthDeathReportDto, HttpStatus.OK);
    }

    @DeleteMapping("/{serialNumber}/death/{targetSerialNumber}")
    public ResponseEntity<Void> deleteDeathReport(@PathVariable Long serialNumber,
                                                  @PathVariable Long targetSerialNumber) {
        birthDeathReportResidentService.deleteBirthDeathReport(serialNumber, targetSerialNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

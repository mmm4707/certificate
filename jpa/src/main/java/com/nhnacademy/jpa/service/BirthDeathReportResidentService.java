package com.nhnacademy.jpa.service;

import com.nhnacademy.jpa.dto.birthDeathReportResident.*;
import org.springframework.transaction.annotation.Transactional;

public interface BirthDeathReportResidentService {

    @Transactional
    BirthDeathReportDto registerBirthReport(Long reportResidentSerialNumber, BirthReportRegisterRequest request);

    @Transactional
    BirthDeathReportDto modifyBirthReport(Long reportResidentSerialNumber, Long residentSerialNumber, BirthReportUpdateRequest request);

    @Transactional
    void deleteBirthDeathReport(Long reportResidentSerialNumber, Long residentSerialNumber);

    @Transactional
    BirthDeathReportDto registerDeathReport(Long reportResidentSerialNumber, DeathReportRegisterRequest request);

    @Transactional
    BirthDeathReportDto modifyDeathReport(Long reportResidentSerialNumber, Long residentSerialNumber, DeathReportUpdateRequest request);
}

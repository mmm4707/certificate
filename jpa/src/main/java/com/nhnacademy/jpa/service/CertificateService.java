package com.nhnacademy.jpa.service;

import com.nhnacademy.jpa.dto.certificate.FamilyRelationAndNumber;
import com.nhnacademy.jpa.dto.resident.ResidentDto;
import com.nhnacademy.jpa.entity.*;

import java.util.List;

public interface CertificateService {
    List<CertificateIssue> getCertificates();
    CertificateIssue getFamilyRelationshipCertificate(Long serialNumber);
    CertificateIssue getResidentRegistration(Long serialNumber);
    CertificateIssue getBirthCertificate(Long serialNumber);
    CertificateIssue getDeathCertificate(Long serialNumber);
    List<FamilyRelationAndNumber> getRelationAndNumber(Long serialNumber);
    Household getHousehold(Long serialNumber);
    List<HouseholdMovementAddress> getAddresses(Long householdSerialNumber);
    List<HouseholdCompositionResident> getHouseholdCompositionResidents(Long householdSerialNumber);
    Resident getFatherByBirthCertificate(Long serialNumber);
    Resident getMotherByBirthCertificate(Long serialNumber);
    BirthDeathReportResident getBirthReport(Long serialNumber);
    BirthDeathReportResident getDeathReport(Long serialNumber);
    ResidentDto getResidentDto(Long serialNumber);
}

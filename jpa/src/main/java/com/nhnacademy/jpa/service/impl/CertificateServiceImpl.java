package com.nhnacademy.jpa.service.impl;

import com.nhnacademy.jpa.dto.certificate.FamilyRelationAndNumber;
import com.nhnacademy.jpa.dto.resident.ResidentDto;
import com.nhnacademy.jpa.entity.*;
import com.nhnacademy.jpa.repository.BirthDeathRepostRepository;
import com.nhnacademy.jpa.repository.CertificateIssueRepository;
import com.nhnacademy.jpa.repository.FamilyRelationshipRepository;
import com.nhnacademy.jpa.repository.HouseholdRepository;
import com.nhnacademy.jpa.repository.HouseholdCompositionResidentRepository;
import com.nhnacademy.jpa.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.jpa.repository.ResidentRepository;
import com.nhnacademy.jpa.service.CertificateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    private final CertificateIssueRepository certificateIssueRepository;
    private final HouseholdRepository householdRepository;
    private final HouseholdMovementAddressRepository householdMovementAddressRepository;
    private final HouseholdCompositionResidentRepository householdCompositionResidentRepository;
    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final BirthDeathRepostRepository birthDeathRepostRepository;
    private final ResidentRepository residentRepository;

    public CertificateServiceImpl(CertificateIssueRepository certificateIssueRepository,
                                  HouseholdRepository householdRepository,
                                  HouseholdMovementAddressRepository householdMovementAddressRepository,
                                  HouseholdCompositionResidentRepository householdCompositionResidentRepository,
                                  FamilyRelationshipRepository familyRelationshipRepository,
                                  BirthDeathRepostRepository birthDeathRepostRepository,
                                  ResidentRepository residentRepository ) {
        this.certificateIssueRepository = certificateIssueRepository;
        this.householdRepository = householdRepository;
        this.householdMovementAddressRepository = householdMovementAddressRepository;
        this.householdCompositionResidentRepository = householdCompositionResidentRepository;
        this.familyRelationshipRepository = familyRelationshipRepository;
        this.birthDeathRepostRepository = birthDeathRepostRepository;
        this.residentRepository = residentRepository;
    }

    @Override
    public List<CertificateIssue> getCertificates() {
        return certificateIssueRepository.findAll();
    }

    @Override
    public CertificateIssue getFamilyRelationshipCertificate(Long serialNumber) {
        return certificateIssueRepository.getFamilyCertificate(serialNumber);
    }

    @Override
    public CertificateIssue getResidentRegistration(Long serialNumber) {
        return certificateIssueRepository.getResidentRegistrationCertificate(serialNumber);
    }

    @Override
    public CertificateIssue getBirthCertificate(Long serialNumber) {
        return certificateIssueRepository.getBirthCertificate(serialNumber);
    }

    @Override
    public CertificateIssue getDeathCertificate(Long serialNumber) {
        return certificateIssueRepository.getDeathCertificate(serialNumber);
    }

    @Override
    public List<FamilyRelationAndNumber> getRelationAndNumber(Long serialNumber) {
        return certificateIssueRepository.getRelationAndNumber(serialNumber);
    }

    @Override
    public Household getHousehold(Long serialNumber) {
        return householdRepository.getHouseholdBySerialNumber(serialNumber);
    }

    @Override
    public List<HouseholdMovementAddress> getAddresses(Long householdSerialNumber) {
        return householdMovementAddressRepository.getMovementAddress(householdSerialNumber);
    }

    @Override
    public List<HouseholdCompositionResident> getHouseholdCompositionResidents(Long householdSerialNumber) {
        return householdCompositionResidentRepository.getCompositionResidents(householdSerialNumber);
    }

    @Override
    public Resident getFatherByBirthCertificate(Long serialNumber) {
        FamilyRelationship fatherRelationship = familyRelationshipRepository.getFatherRelationship(serialNumber);
        return fatherRelationship.getFamilyResident();
    }

    @Override
    public Resident getMotherByBirthCertificate(Long serialNumber) {
        FamilyRelationship motherRelationship = familyRelationshipRepository.getMotherRelationship(serialNumber);
        return motherRelationship.getFamilyResident();
    }

    @Override
    public BirthDeathReportResident getBirthReport(Long serialNumber) {
        return birthDeathRepostRepository.getBirthReportForCertificate(serialNumber);
    }

    @Override
    public BirthDeathReportResident getDeathReport(Long serialNumber) {
        return birthDeathRepostRepository.getDeathReportForCertificate(serialNumber);
    }

    @Override
    public ResidentDto getResidentDto(Long serialNumber) {
        return residentRepository.getResident(serialNumber);
    }
}

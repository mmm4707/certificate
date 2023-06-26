package com.nhnacademy.jpa.service.impl;

import com.nhnacademy.jpa.dto.birthDeathReportResident.*;
import com.nhnacademy.jpa.dto.familyRelationship.RelationshipDto;
import com.nhnacademy.jpa.entity.BirthDeathReportResident;
import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.repository.BirthDeathRepostRepository;
import com.nhnacademy.jpa.repository.FamilyRelationshipRepository;
import com.nhnacademy.jpa.repository.ResidentRepository;
import com.nhnacademy.jpa.service.BirthDeathReportResidentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BirthDeathReportResidentServiceImpl implements BirthDeathReportResidentService {

    private final BirthDeathRepostRepository birthDeathRepostRepository;
    private final ResidentRepository residentRepository;
    private final FamilyRelationshipRepository familyRelationshipRepository;

    public BirthDeathReportResidentServiceImpl(BirthDeathRepostRepository birthDeathRepostRepository, ResidentRepository residentRepository, FamilyRelationshipRepository familyRelationshipRepository) {
        this.birthDeathRepostRepository = birthDeathRepostRepository;
        this.residentRepository = residentRepository;
        this.familyRelationshipRepository = familyRelationshipRepository;
    }

    @Override
    public BirthDeathReportDto registerBirthReport(Long reportResidentSerialNumber, BirthReportRegisterRequest request) {
        BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident();
        birthDeathReportResident.setPk(new BirthDeathReportResident.Pk(
                request.getResidentSerialNumber(), request.getBirthDeathTypeCode()));

        Optional<Resident> reportResident = residentRepository.findById(reportResidentSerialNumber);
        birthDeathReportResident.setReportResident(reportResident.get());

        RelationshipDto relationship = familyRelationshipRepository.getRelationship(request.getResidentSerialNumber(), reportResidentSerialNumber);
        birthDeathReportResident.setBirthReportQualificationsCode(relationship.getFamilyRelationshipCode());

        birthDeathReportResident.setDeathReportQualificationsCode(request.getDeathReportQualificationsCode());
        birthDeathReportResident.setBirthDeathReportDate(request.getBirthDeathReportDate());
        birthDeathReportResident.setEmailAddress(request.getEmailAddress());
        birthDeathReportResident.setPhoneNumber(request.getPhoneNumber());

        Optional<Resident> resident = residentRepository.findById(request.getResidentSerialNumber());
        birthDeathReportResident.setResident(resident.get());

        birthDeathRepostRepository.save(birthDeathReportResident);

        return birthDeathRepostRepository
                .getBirthReport(request.getResidentSerialNumber(), request.getBirthDeathTypeCode());
    }

    @Override
    public BirthDeathReportDto modifyBirthReport(Long reportResidentSerialNumber, Long residentSerialNumber, BirthReportUpdateRequest request) {
        birthDeathRepostRepository.updateBirthDeathReport(reportResidentSerialNumber, residentSerialNumber,
                request.getBirthDeathReportDate(), request.getEmailAddress(), request.getPhoneNumber());

        return birthDeathRepostRepository.getBirthReport(residentSerialNumber, "출생");
    }

    @Override
    public void deleteBirthDeathReport(Long reportResidentSerialNumber, Long residentSerialNumber) {
        birthDeathRepostRepository.deleteBirthDeathReport(reportResidentSerialNumber, residentSerialNumber);
    }

    @Override
    public BirthDeathReportDto registerDeathReport(Long reportResidentSerialNumber, DeathReportRegisterRequest request) {
        BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident();
        birthDeathReportResident.setPk(new BirthDeathReportResident.Pk(
                request.getResidentSerialNumber(), request.getBirthDeathTypeCode()));

        Optional<Resident> reportResident = residentRepository.findById(reportResidentSerialNumber);
        birthDeathReportResident.setReportResident(reportResident.get());

        RelationshipDto relationship = familyRelationshipRepository.getRelationship(request.getResidentSerialNumber(), reportResidentSerialNumber);
        birthDeathReportResident.setDeathReportQualificationsCode(relationship.getFamilyRelationshipCode());

        birthDeathReportResident.setBirthDeathReportDate(request.getBirthDeathReportDate());
        birthDeathReportResident.setEmailAddress(request.getEmailAddress());
        birthDeathReportResident.setPhoneNumber(request.getPhoneNumber());

        Optional<Resident> resident = residentRepository.findById(request.getResidentSerialNumber());
        birthDeathReportResident.setResident(resident.get());

        birthDeathRepostRepository.save(birthDeathReportResident);

        return birthDeathRepostRepository
                .getBirthReport(request.getResidentSerialNumber(), request.getBirthDeathTypeCode());
    }

    @Override
    public BirthDeathReportDto modifyDeathReport(Long reportResidentSerialNumber, Long residentSerialNumber, DeathReportUpdateRequest request) {
        birthDeathRepostRepository.updateBirthDeathReport(reportResidentSerialNumber, residentSerialNumber,
                request.getBirthDeathReportDate(), request.getEmailAddress(), request.getPhoneNumber());

        return birthDeathRepostRepository.getBirthReport(residentSerialNumber, "사망");
    }
}

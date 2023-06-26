package com.nhnacademy.jpa.service.impl;

import com.nhnacademy.jpa.dto.familyRelationship.RelationshipDto;
import com.nhnacademy.jpa.dto.familyRelationship.RelationshipRegisterRequest;
import com.nhnacademy.jpa.dto.familyRelationship.RelationshipUpdateRequest;
import com.nhnacademy.jpa.entity.FamilyRelationship;
import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.repository.FamilyRelationshipRepository;
import com.nhnacademy.jpa.repository.ResidentRepository;
import com.nhnacademy.jpa.service.FamilyRelationshipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyRelationshipServiceImpl implements FamilyRelationshipService {

    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final ResidentRepository residentRepository;

    public FamilyRelationshipServiceImpl(FamilyRelationshipRepository familyRelationshipRepository, ResidentRepository residentRepository) {
        this.familyRelationshipRepository = familyRelationshipRepository;
        this.residentRepository = residentRepository;
    }

    @Override
    public RelationshipDto getRelationship(Long baseResidentNumber, Long familyResidentNumber) {
        return familyRelationshipRepository.getRelationship(baseResidentNumber, familyResidentNumber);
    }

    @Override
    public List<RelationshipDto> getRelationships(Long serialNumber) {
        return familyRelationshipRepository.getFamilyRelationships(serialNumber);
    }

    @Override
    public RelationshipDto registerRelationshipAndGet(Long baseResidentSerialNumber, RelationshipRegisterRequest request) {
        FamilyRelationship familyRelationship = new FamilyRelationship();
        familyRelationship.setPk(new FamilyRelationship.Pk(request.getFamilySerialNumber(), baseResidentSerialNumber));
        familyRelationship.setFamilyRelationshipCode(request.getRelationship());

        Optional<Resident> familyResident = residentRepository.findById(request.getFamilySerialNumber());
        Optional<Resident> baseResident = residentRepository.findById(baseResidentSerialNumber);

        familyRelationship.setFamilyResident(familyResident.get());
        familyRelationship.setBaseResident(baseResident.get());

        familyRelationshipRepository.save(familyRelationship);

        return familyRelationshipRepository
                .getRelationship(baseResidentSerialNumber, request.getFamilySerialNumber());
    }

    @Override
    public void modifyRelationship(Long baseResidentNumber, Long familyResidentNumber,
                                   RelationshipUpdateRequest request) {
        familyRelationshipRepository.updateRelationship(baseResidentNumber, familyResidentNumber, request.getRelationship());
    }

    @Override
    public void deleteRelationship(Long baseResidentNumber, Long familyResidentNumber) {
        familyRelationshipRepository.deleteRelationship(baseResidentNumber, familyResidentNumber);
    }
}

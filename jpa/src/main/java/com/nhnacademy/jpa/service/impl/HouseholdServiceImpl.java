package com.nhnacademy.jpa.service.impl;

import com.nhnacademy.jpa.dto.familyRelationship.RelationshipDto;
import com.nhnacademy.jpa.dto.household.HouseholdDto;
import com.nhnacademy.jpa.dto.household.HouseholdRegisterRequest;
import com.nhnacademy.jpa.entity.Household;
import com.nhnacademy.jpa.entity.HouseholdCompositionResident;
import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.repository.FamilyRelationshipRepository;
import com.nhnacademy.jpa.repository.HouseholdRepository;
import com.nhnacademy.jpa.repository.HouseholdCompositionResidentRepository;
import com.nhnacademy.jpa.repository.ResidentRepository;
import com.nhnacademy.jpa.service.HouseholdService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class HouseholdServiceImpl implements HouseholdService {

    private final HouseholdRepository householdRepository;
    private final HouseholdCompositionResidentRepository householdCompositionResidentRepository;
    private final ResidentRepository residentRepository;
    private final FamilyRelationshipRepository familyRelationshipRepository;

    public HouseholdServiceImpl(HouseholdRepository householdRepository,
                                HouseholdCompositionResidentRepository householdCompositionResidentRepository,
                                ResidentRepository residentRepository,
                                FamilyRelationshipRepository familyRelationshipRepository) {
        this.householdRepository = householdRepository;
        this.householdCompositionResidentRepository = householdCompositionResidentRepository;
        this.residentRepository = residentRepository;
        this.familyRelationshipRepository = familyRelationshipRepository;
    }

    @Override
    @Transactional
    public HouseholdDto registerHousehold(HouseholdRegisterRequest request) {
        Household household = new Household();
        household.setHouseholdSerialNumber(request.getHouseholdSerialNumber());

        Optional<Resident> resident = residentRepository.findById(request.getHouseholdResidentSerialNumber());
        household.setResident(resident.get());

        household.setHouseholdCompositionDate(request.getHouseholdCompositionDate());
        household.setHouseholdCompositionReasonCode(request.getHouseholdCompositionReasonCode());
        household.setCurrentHouseMovementAddress(request.getCurrentHouseMovementAddress());

        householdRepository.save(household);

        HouseholdCompositionResident householdCompositionResident = new HouseholdCompositionResident();
        householdCompositionResident.setPk(new HouseholdCompositionResident.Pk(
                request.getHouseholdSerialNumber(), request.getHouseholdResidentSerialNumber()));

        householdCompositionResident.setReportDate(request.getHouseholdCompositionDate());

        RelationshipDto relationship = familyRelationshipRepository.getRelationship(request.getHouseholdSerialNumber(), request.getHouseholdResidentSerialNumber());
        householdCompositionResident.setHouseholdRelationshipCode(relationship.getFamilyRelationshipCode());
        householdCompositionResident.setHouseholdCompositionChangeReasonCode(request.getHouseholdCompositionReasonCode());
        householdCompositionResident.setHousehold(household);
        householdCompositionResident.setResident(resident.get());
        householdCompositionResidentRepository.save(householdCompositionResident);

        return householdRepository.getHousehold(request.getHouseholdSerialNumber());
    }

    @Override
    public void deleteHousehold(Long householdSerialNumber) {
        householdRepository.deleteById(householdSerialNumber);
        householdCompositionResidentRepository.deleteHouseholdCompositionResidentRepository(householdSerialNumber);
    }
}

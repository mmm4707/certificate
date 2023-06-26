package com.nhnacademy.jpa.service;

import com.nhnacademy.jpa.dto.familyRelationship.RelationshipDto;
import com.nhnacademy.jpa.dto.familyRelationship.RelationshipRegisterRequest;
import com.nhnacademy.jpa.dto.familyRelationship.RelationshipUpdateRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FamilyRelationshipService {

    @Transactional(readOnly = true)
    RelationshipDto getRelationship(Long baseResidentNumber, Long familyResidentNumber);

    List<RelationshipDto> getRelationships(Long serialNumber);

    @Transactional
    RelationshipDto registerRelationshipAndGet(Long baseResidentSerialNumber, RelationshipRegisterRequest request);

    @Transactional
    void modifyRelationship(Long baseResidentNumber, Long familyResidentNumber, RelationshipUpdateRequest request);

    @Transactional
    void deleteRelationship(Long baseResidentNumber, Long familyResidentNumber);
}

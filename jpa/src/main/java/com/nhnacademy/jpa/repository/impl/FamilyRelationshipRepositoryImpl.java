package com.nhnacademy.jpa.repository.impl;

import com.nhnacademy.jpa.dto.familyRelationship.QRelationshipDto;
import com.nhnacademy.jpa.dto.familyRelationship.RelationshipDto;
import com.nhnacademy.jpa.entity.FamilyRelationship;
import com.nhnacademy.jpa.entity.QFamilyRelationship;
import com.nhnacademy.jpa.repository.custom.FamilyRelationshipRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class FamilyRelationshipRepositoryImpl extends QuerydslRepositorySupport implements FamilyRelationshipRepositoryCustom {

    public FamilyRelationshipRepositoryImpl() {
        super(FamilyRelationship.class);
    }

    @Override
    public List<RelationshipDto> getFamilyRelationships(Long baseResidentSerialNumber) {
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;

        return from(familyRelationship)
                .select(new QRelationshipDto(familyRelationship.pk.familyResidentSerialNumber,
                        familyRelationship.pk.baseResidentSerialNumber,
                        familyRelationship.familyRelationshipCode))
                .where(familyRelationship.pk.baseResidentSerialNumber.eq(baseResidentSerialNumber))
                .fetch();
    }

    @Override
    public RelationshipDto getRelationship(Long baseResidentSerialNumber, Long familyResidentSerialNumber) {
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;

        return from(familyRelationship)
                .select(new QRelationshipDto(familyRelationship.pk.familyResidentSerialNumber,
                        familyRelationship.pk.baseResidentSerialNumber,
                        familyRelationship.familyRelationshipCode))
                .where(familyRelationship.pk.baseResidentSerialNumber.eq(baseResidentSerialNumber))
                .where(familyRelationship.pk.familyResidentSerialNumber.eq(familyResidentSerialNumber))
                .fetchOne();
    }
}

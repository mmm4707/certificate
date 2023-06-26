package com.nhnacademy.jpa.repository.impl;

import com.nhnacademy.jpa.dto.certificate.FamilyRelationAndNumber;
import com.nhnacademy.jpa.dto.certificate.QFamilyRelationAndNumber;
import com.nhnacademy.jpa.entity.CertificateIssue;
import com.nhnacademy.jpa.entity.QFamilyRelationship;
import com.nhnacademy.jpa.entity.QResident;
import com.nhnacademy.jpa.repository.custom.CertificateIssueRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CertificateIssueRepositoryImpl extends QuerydslRepositorySupport implements CertificateIssueRepositoryCustom {

    public CertificateIssueRepositoryImpl() {
        super(CertificateIssue.class);
    }

    @Override
    public List<FamilyRelationAndNumber> getRelationAndNumber(Long serialNumber) {
        QResident resident = QResident.resident;
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;

        return from(familyRelationship)
                .innerJoin(familyRelationship.baseResident, resident)
                .select(new QFamilyRelationAndNumber(
                        familyRelationship.pk.familyResidentSerialNumber, familyRelationship.familyRelationshipCode))
                .where(resident.residentSerialNumber.eq(serialNumber))
                .fetch();
    }
}

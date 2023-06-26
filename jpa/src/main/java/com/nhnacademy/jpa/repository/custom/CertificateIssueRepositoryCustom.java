package com.nhnacademy.jpa.repository.custom;

import com.nhnacademy.jpa.dto.certificate.FamilyRelationAndNumber;
import java.util.List;

public interface CertificateIssueRepositoryCustom {

    List<FamilyRelationAndNumber> getRelationAndNumber(Long serialNumber);
}

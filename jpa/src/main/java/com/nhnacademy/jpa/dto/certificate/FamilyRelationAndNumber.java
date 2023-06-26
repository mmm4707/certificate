package com.nhnacademy.jpa.dto.certificate;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@ToString
public class FamilyRelationAndNumber {
    private Long familyResidentSerialNumber;
    private String familyRelationshipCode;

    @QueryProjection
    public FamilyRelationAndNumber(Long familyResidentSerialNumber, String familyRelationshipCode) {
        this.familyResidentSerialNumber = familyResidentSerialNumber;
        this.familyRelationshipCode = familyRelationshipCode;
    }
}

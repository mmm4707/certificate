package com.nhnacademy.jpa.dto.familyRelationship;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@ToString
public class RelationshipDto {
    private Long familyResidentSerialNumber;
    private Long baseResidentSerialNumber;
    private String familyRelationshipCode;

    @QueryProjection
    public RelationshipDto(Long familyResidentSerialNumber, Long baseResidentSerialNumber, String familyRelationshipCode) {
        this.familyResidentSerialNumber = familyResidentSerialNumber;
        this.baseResidentSerialNumber = baseResidentSerialNumber;
        this.familyRelationshipCode = familyRelationshipCode;
    }
}

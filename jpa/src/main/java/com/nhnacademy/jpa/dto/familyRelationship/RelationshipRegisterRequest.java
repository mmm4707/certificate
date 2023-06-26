package com.nhnacademy.jpa.dto.familyRelationship;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RelationshipRegisterRequest {
    private Long familySerialNumber;
    private String relationship;
}

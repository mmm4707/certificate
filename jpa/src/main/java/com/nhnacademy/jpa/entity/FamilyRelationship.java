package com.nhnacademy.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "family_relationship")
public class FamilyRelationship {

    @EmbeddedId
    private Pk pk;

    @Column(name = "family_relationship_code")
    private String familyRelationshipCode;

    @MapsId("familyResidentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "family_resident_serial_number")
    private Resident familyResident;

    @MapsId("baseResidentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "base_resident_serial_number")
    private Resident baseResident;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class Pk implements Serializable {

        @Column(name = "family_resident_serial_number")
        private Long familyResidentSerialNumber;

        @Column(name = "base_resident_serial_number")
        private Long baseResidentSerialNumber;
    }

}

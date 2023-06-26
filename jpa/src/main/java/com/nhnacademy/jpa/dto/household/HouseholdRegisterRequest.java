package com.nhnacademy.jpa.dto.household;

import lombok.*;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HouseholdRegisterRequest {
    private Long householdSerialNumber;
    private Long householdResidentSerialNumber;
    private Date householdCompositionDate;
    private String householdCompositionReasonCode;
    private String currentHouseMovementAddress;
}

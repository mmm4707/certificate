package com.nhnacademy.jpa.dto.householdAddress;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HouseholdMovementUpdateRequest {
    private String houseMovementAddress;
    private String lastAddressYn;
}

package com.nhnacademy.jpa.dto.householdAddress;

import lombok.*;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HouseholdMovementRegisterRequest {
    private Date houseMovementReportDate;
    private String houseMovementAddress;
    private String lastAddressYn;
}

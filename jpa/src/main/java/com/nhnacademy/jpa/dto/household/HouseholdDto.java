package com.nhnacademy.jpa.dto.household;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@ToString
public class HouseholdDto {
    private Long householdSerialNumber;
    private Long residentSerialNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date reportDate;
    private String householdCompositionReasonCode;
    private String currentHouseMovementAddress;

    @QueryProjection
    public HouseholdDto(Long householdSerialNumber, Long residentSerialNumber, Date reportDate, String householdCompositionReasonCode, String currentHouseMovementAddress) {
        this.householdSerialNumber = householdSerialNumber;
        this.residentSerialNumber = residentSerialNumber;
        this.reportDate = reportDate;
        this.householdCompositionReasonCode = householdCompositionReasonCode;
        this.currentHouseMovementAddress = currentHouseMovementAddress;
    }
}

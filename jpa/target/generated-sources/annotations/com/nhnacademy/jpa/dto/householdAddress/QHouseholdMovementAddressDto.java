package com.nhnacademy.jpa.dto.householdAddress;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.nhnacademy.jpa.dto.householdAddress.QHouseholdMovementAddressDto is a Querydsl Projection type for HouseholdMovementAddressDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QHouseholdMovementAddressDto extends ConstructorExpression<HouseholdMovementAddressDto> {

    private static final long serialVersionUID = 205626571L;

    public QHouseholdMovementAddressDto(com.querydsl.core.types.Expression<Long> householdSerialNumber, com.querydsl.core.types.Expression<? extends java.util.Date> houseMovementReportDate, com.querydsl.core.types.Expression<String> houseMovementAddress, com.querydsl.core.types.Expression<String> lastAddressYn) {
        super(HouseholdMovementAddressDto.class, new Class<?>[]{long.class, java.util.Date.class, String.class, String.class}, householdSerialNumber, houseMovementReportDate, houseMovementAddress, lastAddressYn);
    }

}


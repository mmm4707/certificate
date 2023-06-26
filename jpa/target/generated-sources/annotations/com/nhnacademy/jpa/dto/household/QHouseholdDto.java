package com.nhnacademy.jpa.dto.household;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.nhnacademy.jpa.dto.household.QHouseholdDto is a Querydsl Projection type for HouseholdDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QHouseholdDto extends ConstructorExpression<HouseholdDto> {

    private static final long serialVersionUID = -929360838L;

    public QHouseholdDto(com.querydsl.core.types.Expression<Long> householdSerialNumber, com.querydsl.core.types.Expression<Long> residentSerialNumber, com.querydsl.core.types.Expression<? extends java.util.Date> reportDate, com.querydsl.core.types.Expression<String> householdCompositionReasonCode, com.querydsl.core.types.Expression<String> currentHouseMovementAddress) {
        super(HouseholdDto.class, new Class<?>[]{long.class, long.class, java.util.Date.class, String.class, String.class}, householdSerialNumber, residentSerialNumber, reportDate, householdCompositionReasonCode, currentHouseMovementAddress);
    }

}


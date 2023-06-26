package com.nhnacademy.jpa.repository.impl;

import com.nhnacademy.jpa.dto.household.HouseholdDto;
import com.nhnacademy.jpa.dto.household.QHouseholdDto;
import com.nhnacademy.jpa.entity.Household;
import com.nhnacademy.jpa.entity.QHousehold;
import com.nhnacademy.jpa.repository.custom.HouseholdRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class HouseholdRepositoryImpl extends QuerydslRepositorySupport implements HouseholdRepositoryCustom {

    public HouseholdRepositoryImpl() {
        super(Household.class);
    }

    @Override
    public HouseholdDto getHousehold(Long householdSerialNumber) {
        QHousehold household = QHousehold.household;

        return from(household)
                .select(new QHouseholdDto(
                        household.householdSerialNumber,
                        household.resident.residentSerialNumber,
                        household.householdCompositionDate,
                        household.householdCompositionReasonCode,
                        household.currentHouseMovementAddress))
                .where(household.householdSerialNumber.eq(householdSerialNumber))
                .fetchOne();
    }
}

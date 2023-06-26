package com.nhnacademy.jpa.repository.impl;

import com.nhnacademy.jpa.dto.householdAddress.HouseholdMovementAddressDto;
import com.nhnacademy.jpa.dto.householdAddress.QHouseholdMovementAddressDto;
import com.nhnacademy.jpa.entity.HouseholdMovementAddress;
import com.nhnacademy.jpa.entity.QHouseholdMovementAddress;
import com.nhnacademy.jpa.repository.custom.HouseholdMovementAddressRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Date;

public class HouseholdMovementAddressRepositoryImpl extends QuerydslRepositorySupport implements HouseholdMovementAddressRepositoryCustom {

    public HouseholdMovementAddressRepositoryImpl() {
        super(HouseholdMovementAddress.class);
    }

    @Override
    public HouseholdMovementAddressDto getHouseMovementAddress(Long householdSerialNumber, Date reportDate) {
        QHouseholdMovementAddress householdMovementAddress = QHouseholdMovementAddress.householdMovementAddress;

        String date = reportDate.getYear() +"-"+ reportDate.getMonth()+"-"+reportDate.getDate();

        return from(householdMovementAddress)
                .select(new QHouseholdMovementAddressDto(
                        householdMovementAddress.pk.householdSerialNumber,
                        householdMovementAddress.pk.houseMovementReportDate,
                        householdMovementAddress.houseMovementAddress,
                        householdMovementAddress.lastAddressYn))
                .where(householdMovementAddress.pk.householdSerialNumber.eq(householdSerialNumber))
                .where(householdMovementAddress.pk.houseMovementReportDate.eq(reportDate))
                .fetchOne();
    }
}

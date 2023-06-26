package com.nhnacademy.jpa.service;

import com.nhnacademy.jpa.dto.householdAddress.HouseholdMovementAddressDto;
import com.nhnacademy.jpa.dto.householdAddress.HouseholdMovementRegisterRequest;
import com.nhnacademy.jpa.dto.householdAddress.HouseholdMovementUpdateRequest;
import org.springframework.transaction.annotation.Transactional;
import java.text.ParseException;

public interface HouseholdMovementAddressService {

    @Transactional
    HouseholdMovementAddressDto registerAddress(Long householdSerialNumber, HouseholdMovementRegisterRequest request);

    @Transactional
    HouseholdMovementAddressDto modifyAddress(Long householdSerialNumber, String reportDate, HouseholdMovementUpdateRequest request) throws ParseException;

    @Transactional
    void deleteAddress(Long householdSerialNumber, String reportDate) throws ParseException;
}

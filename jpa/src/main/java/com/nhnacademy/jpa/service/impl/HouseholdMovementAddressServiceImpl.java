package com.nhnacademy.jpa.service.impl;

import com.nhnacademy.jpa.dto.householdAddress.HouseholdMovementAddressDto;
import com.nhnacademy.jpa.dto.householdAddress.HouseholdMovementRegisterRequest;
import com.nhnacademy.jpa.dto.householdAddress.HouseholdMovementUpdateRequest;
import com.nhnacademy.jpa.entity.Household;
import com.nhnacademy.jpa.entity.HouseholdMovementAddress;
import com.nhnacademy.jpa.repository.HouseholdRepository;
import com.nhnacademy.jpa.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.jpa.service.HouseholdMovementAddressService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class HouseholdMovementAddressServiceImpl implements HouseholdMovementAddressService {

    private final HouseholdMovementAddressRepository householdMovementAddressRepository;
    private final HouseholdRepository householdRepository;

    public HouseholdMovementAddressServiceImpl(HouseholdMovementAddressRepository householdMovementAddressRepository, HouseholdRepository householdRepository) {
        this.householdMovementAddressRepository = householdMovementAddressRepository;
        this.householdRepository = householdRepository;
    }

    @Override
    public HouseholdMovementAddressDto registerAddress(Long householdSerialNumber, HouseholdMovementRegisterRequest request) {
        HouseholdMovementAddress householdMovementAddress = new HouseholdMovementAddress();
        householdMovementAddress.setPk(new HouseholdMovementAddress.Pk(
                householdSerialNumber, request.getHouseMovementReportDate()));

        householdMovementAddress.setHouseMovementAddress(request.getHouseMovementAddress());
        householdMovementAddress.setLastAddressYn(request.getLastAddressYn());

        Optional<Household> household = householdRepository.findById(householdSerialNumber);
        householdMovementAddress.setHousehold(household.get());

        householdMovementAddressRepository.save(householdMovementAddress);

        return householdMovementAddressRepository
                .getHouseMovementAddress(householdSerialNumber, request.getHouseMovementReportDate());
    }

    @Override
    public HouseholdMovementAddressDto modifyAddress(Long householdSerialNumber, String reportDate,
                                                     HouseholdMovementUpdateRequest request) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyymmdd");
        Date date = format.parse(reportDate);

        householdMovementAddressRepository.updateMovementAddress(householdSerialNumber, date,
                request.getHouseMovementAddress(), request.getLastAddressYn());
        return householdMovementAddressRepository
                .getHouseMovementAddress(householdSerialNumber, date);
    }

    @Override
    public void deleteAddress(Long householdSerialNumber, String reportDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyymmdd");
        Date date = format.parse(reportDate);

        householdMovementAddressRepository.deleteMovementAddress(householdSerialNumber, date);
    }
}

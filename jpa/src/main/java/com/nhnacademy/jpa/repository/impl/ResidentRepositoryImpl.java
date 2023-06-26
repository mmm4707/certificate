package com.nhnacademy.jpa.repository.impl;

import com.nhnacademy.jpa.dto.resident.QResidentDto;
import com.nhnacademy.jpa.dto.resident.ResidentDto;
import com.nhnacademy.jpa.entity.QResident;
import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.repository.custom.ResidentRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ResidentRepositoryImpl extends QuerydslRepositorySupport implements ResidentRepositoryCustom {

    public ResidentRepositoryImpl() {
        super(Resident.class);
    }

    @Override
    public List<ResidentDto> getResidents() {
        QResident resident = QResident.resident;

        return from(resident)
                .select(new QResidentDto(
                        resident.residentSerialNumber,
                        resident.name,
                        resident.residentRegistrationNumber,
                        resident.genderCode,
                        resident.birthDate,
                        resident.birthPlaceCode,
                        resident.registrationBaseAddress,
                        resident.deathDate,
                        resident.deathPlaceCode,
                        resident.deathPlaceAddress))
                .fetch();
    }

    @Override
    public ResidentDto getResident(Long residentSerialNumber) {
        QResident resident = QResident.resident;

        return from(resident)
                .select(new QResidentDto(
                        resident.residentSerialNumber,
                        resident.name,
                        resident.residentRegistrationNumber,
                        resident.genderCode,
                        resident.birthDate,
                        resident.birthPlaceCode,
                        resident.registrationBaseAddress,
                        resident.deathDate,
                        resident.deathPlaceCode,
                        resident.deathPlaceAddress))
                .where(resident.residentSerialNumber.eq(residentSerialNumber))
                .fetchOne();
    }
}

package com.nhnacademy.jpa.service;

import com.nhnacademy.jpa.dto.resident.ResidentDto;
import com.nhnacademy.jpa.dto.resident.ResidentRegisterRequest;
import com.nhnacademy.jpa.dto.resident.ResidentUpdateRequest;
import com.nhnacademy.jpa.entity.Resident;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ResidentService {

    int getResidentsTotalPages(Pageable pageable);

    List<Resident> getResidents(Pageable pageable);

    @Transactional(readOnly = true)
    ResidentDto getResident(Long serialNumber);

    @Transactional
    Resident registerResident(ResidentRegisterRequest residentRegisterRequest);

    @Transactional
    ResidentDto modifyResident(Long serialNumber, ResidentUpdateRequest residentUpdateRequest);

    @Transactional
    void deleteResident(Long serialNumber);
}

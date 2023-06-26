package com.nhnacademy.jpa.service.impl;

import com.nhnacademy.jpa.dto.resident.ResidentDto;
import com.nhnacademy.jpa.dto.resident.ResidentRegisterRequest;
import com.nhnacademy.jpa.dto.resident.ResidentUpdateRequest;
import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.repository.ResidentRepository;
import com.nhnacademy.jpa.service.ResidentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;

    public ResidentServiceImpl(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Override
    public int getResidentsTotalPages(Pageable pageable) {
        return residentRepository.getAllBy(pageable).getTotalPages();
    }

    @Override
    public List<Resident> getResidents(Pageable pageable) {
        return residentRepository.getAllBy(pageable).getContent();
    }

    @Override
    public ResidentDto getResident(Long serialNumber) {
        return residentRepository.getResident(serialNumber);
    }

    @Override
    public Resident registerResident(ResidentRegisterRequest residentRegisterRequest) {
        Resident resident = new Resident();
        resident.setResidentSerialNumber(residentRegisterRequest.getResidentSerialNumber());
        resident.setName(residentRegisterRequest.getName());
        resident.setResidentRegistrationNumber(residentRegisterRequest.getResidentRegistrationNumber());
        resident.setGenderCode(residentRegisterRequest.getGenderCode());
        resident.setBirthDate(residentRegisterRequest.getBirthDate());
        resident.setBirthPlaceCode(residentRegisterRequest.getBirthPlaceCode());
        resident.setRegistrationBaseAddress(residentRegisterRequest.getRegistrationBaseAddress());
        resident.setDeathDate(residentRegisterRequest.getDeathDate());
        resident.setDeathPlaceCode(residentRegisterRequest.getDeathPlaceCode());
        resident.setDeathPlaceAddress(residentRegisterRequest.getDeathPlaceAddress());

        return residentRepository.save(resident);
    }

    @Override
    public ResidentDto modifyResident(Long serialNumber, ResidentUpdateRequest residentUpdateRequest) {
        residentRepository.updateResident(serialNumber,
                                            residentUpdateRequest.getName(),
                                            residentUpdateRequest.getDeathDate(),
                                            residentUpdateRequest.getDeathPlaceCode(),
                                            residentUpdateRequest.getDeathPlaceAddress());
        return residentRepository.getResident(serialNumber);
    }

    @Override
    public void deleteResident(Long serialNumber) {
        residentRepository.deleteByResidentSerialNumber(serialNumber);
    }

}

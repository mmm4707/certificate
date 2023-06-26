package com.nhnacademy.jpa.repository;

import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.repository.custom.ResidentRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface ResidentRepository extends ResidentRepositoryCustom, JpaRepository<Resident, Long> {

    @Transactional
    @Modifying
    @Query("update Resident R SET R.name = ?2, " +
            "R.deathDate = ?3, R.deathPlaceCode = ?4, " +
            "R.deathPlaceAddress = ?5 " +
            "where R.residentSerialNumber = ?1")
    int updateResident(Long serialNumber, String name, LocalDateTime date, String deathPlaceCode, String deathPlaceAddress);

    @Transactional
    void deleteByResidentSerialNumber(Long serialNumber);

    Page<Resident> getAllBy(Pageable pageable);

}

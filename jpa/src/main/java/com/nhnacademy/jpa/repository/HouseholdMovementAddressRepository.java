package com.nhnacademy.jpa.repository;

import com.nhnacademy.jpa.entity.HouseholdMovementAddress;
import com.nhnacademy.jpa.repository.custom.HouseholdMovementAddressRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

public interface HouseholdMovementAddressRepository extends
        HouseholdMovementAddressRepositoryCustom, JpaRepository<HouseholdMovementAddress, HouseholdMovementAddress.Pk> {

    @Transactional
    @Modifying
    @Query("UPDATE HouseholdMovementAddress h SET h.houseMovementAddress = ?3, h.lastAddressYn = ?4 " +
            "where h.pk.householdSerialNumber = ?1 and h.pk.houseMovementReportDate = ?2")
    void updateMovementAddress(Long householdSerialNumber, Date reportDate, String address, String lastAddress);

    @Transactional
    @Modifying
    @Query("DELETE FROM HouseholdMovementAddress h where h.pk.householdSerialNumber = ?1 and h.pk.houseMovementReportDate = ?2")
    void deleteMovementAddress(Long householdSerialNumber, Date reportDate);

    @Query(value = "select * from household_movement_address " +
            "where household_serial_number = ?1 " +
            "order by house_movement_report_date desc", nativeQuery = true)
    List<HouseholdMovementAddress> getMovementAddress(Long householdSerialNumber);
}

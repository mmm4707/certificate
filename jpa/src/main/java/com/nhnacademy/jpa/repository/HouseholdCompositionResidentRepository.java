package com.nhnacademy.jpa.repository;

import com.nhnacademy.jpa.entity.HouseholdCompositionResident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HouseholdCompositionResidentRepository extends JpaRepository<HouseholdCompositionResident, HouseholdCompositionResident.Pk> {

    @Transactional
    @Modifying
    @Query("DELETE FROM HouseholdCompositionResident h where h.pk.householdSerialNumber = ?1")
    void deleteHouseholdCompositionResidentRepository(Long householdSerialNumber);

    @Query(value = "select * from household_composition_resident " +
            "where household_serial_number = ?1", nativeQuery = true)
    List<HouseholdCompositionResident> getCompositionResidents(Long householdSerialNumber);
}

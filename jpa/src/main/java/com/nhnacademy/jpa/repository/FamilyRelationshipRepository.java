package com.nhnacademy.jpa.repository;


import com.nhnacademy.jpa.entity.FamilyRelationship;
import com.nhnacademy.jpa.repository.custom.FamilyRelationshipRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface FamilyRelationshipRepository extends FamilyRelationshipRepositoryCustom, JpaRepository<FamilyRelationship, FamilyRelationship.Pk> {

    @Transactional
    @Modifying
    @Query("UPDATE FamilyRelationship f SET f.familyRelationshipCode = ?3 " +
            "where f.pk.baseResidentSerialNumber = ?1 and f.pk.familyResidentSerialNumber = ?2")
    void updateRelationship(Long baseResidentNumber, Long familyResidentNumber, String relationship);

    @Transactional
    @Modifying
    @Query("DELETE FROM FamilyRelationship f " +
            "where f.pk.baseResidentSerialNumber = ?1 and f.pk.familyResidentSerialNumber = ?2")
    void deleteRelationship(Long baseResidentNumber, Long familyResidentNumber);

    @Query(value = "select * from family_relationship " +
            "where base_resident_serial_number = ?1 and family_relationship_code = '부'", nativeQuery = true)
    FamilyRelationship getFatherRelationship(Long baseResidentNumber);

    @Query(value = "select * from family_relationship " +
            "where base_resident_serial_number = ?1 and family_relationship_code = '모'", nativeQuery = true)
    FamilyRelationship getMotherRelationship(Long baseResidentNumber);
}

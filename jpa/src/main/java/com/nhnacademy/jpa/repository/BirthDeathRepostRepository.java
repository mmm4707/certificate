package com.nhnacademy.jpa.repository;

import com.nhnacademy.jpa.entity.BirthDeathReportResident;
import com.nhnacademy.jpa.repository.custom.BirthDeathRepostRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface BirthDeathRepostRepository extends BirthDeathRepostRepositoryCustom,
        JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk> {

    @Transactional
    @Modifying
    @Query("UPDATE BirthDeathReportResident b set b.birthDeathReportDate = ?3, b.emailAddress = ?4, b.phoneNumber = ?5 " +
            "where b.pk.residentSerialNumber = ?2 and b.reportResident.residentSerialNumber = ?1")
    void updateBirthDeathReport(Long reportResidentSerialNumber, Long residentSerialNumber,
                                Date date, String email, String phoneNumber);

    @Transactional
    @Modifying
    @Query("DELETE FROM BirthDeathReportResident b " +
            "where b.reportResident.residentSerialNumber = ?1 and b.pk.residentSerialNumber = ?2")
    void deleteBirthDeathReport(Long reportResidentSerialNumber, Long residentSerialNumber);

    @Query(value = "select * from birth_death_report_resident " +
            "where resident_serial_number = ?1 and birth_death_type_code = '출생'", nativeQuery = true)
    BirthDeathReportResident getBirthReportForCertificate(Long serialNumber);

    @Query(value = "select * from birth_death_report_resident " +
            "where resident_serial_number = ?1 and birth_death_type_code = '사망'", nativeQuery = true)
    BirthDeathReportResident getDeathReportForCertificate(Long serialNumber);
}

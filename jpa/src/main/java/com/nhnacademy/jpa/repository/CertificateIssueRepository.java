package com.nhnacademy.jpa.repository;

import com.nhnacademy.jpa.entity.CertificateIssue;
import com.nhnacademy.jpa.repository.custom.CertificateIssueRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CertificateIssueRepository extends CertificateIssueRepositoryCustom, JpaRepository<CertificateIssue, Long> {

    @Query(value = "select * from certificate_issue " +
            "where resident_serial_number = ?1 and certificate_type_code = '가족관계증명서'", nativeQuery = true)
    CertificateIssue getFamilyCertificate(Long serialNumber);

    @Query(value = "select * from certificate_issue " +
            "where resident_serial_number = ?1 and certificate_type_code = '주민등록등본'", nativeQuery = true)
    CertificateIssue getResidentRegistrationCertificate(Long serialNumber);

    @Query(value = "select * from certificate_issue " +
            "where resident_serial_number = ?1 and certificate_type_code = '출생신고서'", nativeQuery = true)
    CertificateIssue getBirthCertificate(Long serialNumber);

    @Query(value = "select * from certificate_issue " +
            "where resident_serial_number = ?1 and certificate_type_code = '사망신고서'", nativeQuery = true)
    CertificateIssue getDeathCertificate(Long serialNumber);
}

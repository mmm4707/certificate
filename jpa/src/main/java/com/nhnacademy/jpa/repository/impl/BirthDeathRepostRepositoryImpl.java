package com.nhnacademy.jpa.repository.impl;

import com.nhnacademy.jpa.dto.birthDeathReportResident.BirthDeathReportDto;
import com.nhnacademy.jpa.dto.birthDeathReportResident.QBirthDeathReportDto;
import com.nhnacademy.jpa.entity.BirthDeathReportResident;
import com.nhnacademy.jpa.entity.QBirthDeathReportResident;
import com.nhnacademy.jpa.repository.custom.BirthDeathRepostRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class BirthDeathRepostRepositoryImpl extends QuerydslRepositorySupport implements BirthDeathRepostRepositoryCustom {

    public BirthDeathRepostRepositoryImpl() {
        super(BirthDeathReportResident.class);
    }

    @Override
    public BirthDeathReportDto getBirthReport(Long serialNumber, String birthDeathCode) {
        QBirthDeathReportResident birthDeathReportResident = QBirthDeathReportResident.birthDeathReportResident;

        return from(birthDeathReportResident)
                .select(new QBirthDeathReportDto(
                        birthDeathReportResident.pk.residentSerialNumber,
                        birthDeathReportResident.pk.birthDeathTypeCode,
                        birthDeathReportResident.reportResident.residentSerialNumber,
                        birthDeathReportResident.birthDeathReportDate,
                        birthDeathReportResident.birthReportQualificationsCode,
                        birthDeathReportResident.deathReportQualificationsCode,
                        birthDeathReportResident.emailAddress,
                        birthDeathReportResident.phoneNumber))
                .where(birthDeathReportResident.pk.residentSerialNumber.eq(serialNumber))
                .where(birthDeathReportResident.pk.birthDeathTypeCode.eq(birthDeathCode))
                .fetchOne();
    }
}

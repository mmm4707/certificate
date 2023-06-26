package com.nhnacademy.jpa.dto.birthDeathReportResident;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.nhnacademy.jpa.dto.birthDeathReportResident.QBirthDeathReportDto is a Querydsl Projection type for BirthDeathReportDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QBirthDeathReportDto extends ConstructorExpression<BirthDeathReportDto> {

    private static final long serialVersionUID = 630050476L;

    public QBirthDeathReportDto(com.querydsl.core.types.Expression<Long> residentSerialNumber, com.querydsl.core.types.Expression<String> birthDeathTypeCode, com.querydsl.core.types.Expression<Long> reportResidentSerialNumber, com.querydsl.core.types.Expression<? extends java.util.Date> birthDeathReportDate, com.querydsl.core.types.Expression<String> birthReportQualificationsCode, com.querydsl.core.types.Expression<String> deathReportQualificationsCode, com.querydsl.core.types.Expression<String> emailAddress, com.querydsl.core.types.Expression<String> phoneNumber) {
        super(BirthDeathReportDto.class, new Class<?>[]{long.class, String.class, long.class, java.util.Date.class, String.class, String.class, String.class, String.class}, residentSerialNumber, birthDeathTypeCode, reportResidentSerialNumber, birthDeathReportDate, birthReportQualificationsCode, deathReportQualificationsCode, emailAddress, phoneNumber);
    }

}


package com.nhnacademy.jpa.dto.resident;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.nhnacademy.jpa.dto.resident.QResidentDto is a Querydsl Projection type for ResidentDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QResidentDto extends ConstructorExpression<ResidentDto> {

    private static final long serialVersionUID = -1943515556L;

    public QResidentDto(com.querydsl.core.types.Expression<Long> serialNumber, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> residentRegistrationNumber, com.querydsl.core.types.Expression<String> genderCode, com.querydsl.core.types.Expression<java.time.LocalDateTime> birthDate, com.querydsl.core.types.Expression<String> birthPlaceCode, com.querydsl.core.types.Expression<String> registrationBaseAddress, com.querydsl.core.types.Expression<java.time.LocalDateTime> deathTime, com.querydsl.core.types.Expression<String> deathPlaceCode, com.querydsl.core.types.Expression<String> deathPlaceAddress) {
        super(ResidentDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, java.time.LocalDateTime.class, String.class, String.class, java.time.LocalDateTime.class, String.class, String.class}, serialNumber, name, residentRegistrationNumber, genderCode, birthDate, birthPlaceCode, registrationBaseAddress, deathTime, deathPlaceCode, deathPlaceAddress);
    }

}


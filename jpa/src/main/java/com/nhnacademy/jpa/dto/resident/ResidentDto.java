package com.nhnacademy.jpa.dto.resident;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
@NoArgsConstructor
public class ResidentDto {
    Long serialNumber;
    String name;
    String residentRegistrationNumber;
    String genderCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    LocalDateTime birthDate;
    String birthPlaceCode;
    String registrationBaseAddress;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    LocalDateTime deathTime;
    String deathPlaceCode;
    String deathPlaceAddress;

    @QueryProjection
    public ResidentDto(Long serialNumber, String name, String residentRegistrationNumber, String genderCode, LocalDateTime birthDate, String birthPlaceCode, String registrationBaseAddress, LocalDateTime deathTime, String deathPlaceCode, String deathPlaceAddress) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.residentRegistrationNumber = residentRegistrationNumber;
        this.genderCode = genderCode;
        this.birthDate = birthDate;
        this.birthPlaceCode = birthPlaceCode;
        this.registrationBaseAddress = registrationBaseAddress;
        this.deathTime = deathTime;
        this.deathPlaceCode = deathPlaceCode;
        this.deathPlaceAddress = deathPlaceAddress;
    }
}

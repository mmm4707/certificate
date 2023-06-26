package com.nhnacademy.jpa.dto.birthDeathReportResident;

import lombok.*;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeathReportRegisterRequest {
    private Long residentSerialNumber;
    private String birthDeathTypeCode;
    private Date birthDeathReportDate;
    private String birthReportQualificationsCode;
    private String emailAddress;
    private String phoneNumber;
}

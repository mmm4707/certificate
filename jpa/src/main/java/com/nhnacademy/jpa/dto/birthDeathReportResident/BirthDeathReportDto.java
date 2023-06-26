package com.nhnacademy.jpa.dto.birthDeathReportResident;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@ToString
public class BirthDeathReportDto {
    private Long residentSerialNumber;
    private String birthDeathTypeCode;
    private Long reportResidentSerialNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date birthDeathReportDate;
    private String birthReportQualificationsCode;
    private String deathReportQualificationsCode;
    private String emailAddress;
    private String phoneNumber;

    @QueryProjection
    public BirthDeathReportDto(Long residentSerialNumber, String birthDeathTypeCode, Long reportResidentSerialNumber, Date birthDeathReportDate, String birthReportQualificationsCode, String deathReportQualificationsCode, String emailAddress, String phoneNumber) {
        this.residentSerialNumber = residentSerialNumber;
        this.birthDeathTypeCode = birthDeathTypeCode;
        this.reportResidentSerialNumber = reportResidentSerialNumber;
        this.birthDeathReportDate = birthDeathReportDate;
        this.birthReportQualificationsCode = birthReportQualificationsCode;
        this.deathReportQualificationsCode = deathReportQualificationsCode;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }


}

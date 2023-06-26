package com.nhnacademy.jpa.dto.resident;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResidentRegisterRequest {
    private Long residentSerialNumber;
    private String name;
    private String residentRegistrationNumber;
    private String genderCode;
    private LocalDateTime birthDate;
    private String birthPlaceCode;
    private String registrationBaseAddress;
    private LocalDateTime deathDate;
    private String deathPlaceCode;
    private String deathPlaceAddress;
}

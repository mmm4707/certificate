package com.nhnacademy.jpa.dto.certificate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResidentRegistrationAddress {
    private String addressComposition;
    private String address;
    private String reportDate;
}

package com.nhnacademy.jpa.controller;

import com.nhnacademy.jpa.dto.certificate.FamilyComposition;
import com.nhnacademy.jpa.dto.certificate.FamilyRelationAndNumber;
import com.nhnacademy.jpa.dto.certificate.ResidentRegistrationAddress;
import com.nhnacademy.jpa.dto.certificate.ResidentRegistrationInfo;
import com.nhnacademy.jpa.dto.resident.ResidentDto;
import com.nhnacademy.jpa.entity.*;
import com.nhnacademy.jpa.service.CertificateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class CertificateController {

    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @GetMapping("/certificates")
    public String listCertificates(Model model) {
        List<CertificateIssue> certificates = certificateService.getCertificates();
        model.addAttribute("certificates", certificates);
        return "certificate/certificates";
    }

    @GetMapping("/birth/certificate/{serialNumber}")
    public String birthCertificate(@PathVariable("serialNumber") Long serialNumber, Model model) {
        CertificateIssue certificate = certificateService.getBirthCertificate(serialNumber);
        if (Objects.isNull(certificate)) {
            return "nullex";
        }

        Date reportDate = certificate.getCertificateIssueDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");

        Resident father = certificateService.getFatherByBirthCertificate(serialNumber);
        Resident mother = certificateService.getMotherByBirthCertificate(serialNumber);
        BirthDeathReportResident birthReport = certificateService.getBirthReport(serialNumber);

        model.addAttribute("reportDate", format.format(reportDate));
        model.addAttribute("birthDate", certificate.getResident().getBirthDate().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분")));
        model.addAttribute("certificate", certificate);
        model.addAttribute("father", father);
        model.addAttribute("mother", mother);
        model.addAttribute("birthReport", birthReport);

        return "certificate/birth";
    }

    @GetMapping("/death/certificate/{serialNumber}")
    public String deathCertificate(@PathVariable("serialNumber") Long serialNumber, Model model) {
        CertificateIssue certificate = certificateService.getDeathCertificate(serialNumber);
        if (Objects.isNull(certificate)) {
            return "nullex";
        }

        Date reportDate = certificate.getCertificateIssueDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");

        BirthDeathReportResident deathReport = certificateService.getDeathReport(serialNumber);

        model.addAttribute("reportDate", format.format(reportDate));
        model.addAttribute("certificate", certificate);
        model.addAttribute("deathDate", certificate.getResident().getDeathDate().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분")));
        model.addAttribute("deathReport", deathReport);

        return "certificate/death";
    }

    @GetMapping("/family/certificate/{serialNumber}")
    public String familyCertificate(@PathVariable("serialNumber") Long serialNumber, Model model) {
        CertificateIssue certificate = certificateService.getFamilyRelationshipCertificate(serialNumber);
        if (Objects.isNull(certificate)) {
            return "nullex";
        }
        ResidentDto resident = certificateService.getResidentDto(serialNumber);
        List<FamilyRelationAndNumber> relationAndNumbers = certificateService.getRelationAndNumber(serialNumber);

        List<FamilyComposition> contents = new ArrayList<>();
        contents.add(new FamilyComposition("본인", resident.getName(), resident.getBirthDate().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")),
                resident.getResidentRegistrationNumber(), resident.getGenderCode()));

        for (FamilyRelationAndNumber number : relationAndNumbers) {
            ResidentDto tmp = certificateService.getResidentDto(number.getFamilyResidentSerialNumber());
            contents.add(new FamilyComposition(number.getFamilyRelationshipCode(), tmp.getName(),
                    tmp.getBirthDate().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")), tmp.getResidentRegistrationNumber(), tmp.getGenderCode()));
        }

        Date reportDate = certificate.getCertificateIssueDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");

        model.addAttribute("certificate", certificate);
        model.addAttribute("reportDate", format.format(reportDate));
        model.addAttribute("address", resident.getRegistrationBaseAddress());
        model.addAttribute("contents", contents);

        return "certificate/familyCertificate";
    }

    @GetMapping("/residentRegistration/certificate/{serialNumber}")
    public String residentRegistration(@PathVariable("serialNumber") Long serialNumber, Model model) {
        CertificateIssue certificate = certificateService.getResidentRegistration(serialNumber);
        if (Objects.isNull(certificate)) {
            return "nullex";
        }
        Household household = certificateService.getHousehold(serialNumber);

        List<HouseholdMovementAddress> tmp1 = certificateService.getAddresses(household.getHouseholdSerialNumber());
        List<ResidentRegistrationAddress> addresses = new ArrayList<>();

        for (HouseholdMovementAddress address : tmp1) {
            String yn = "";
            if (address.getLastAddressYn().equals("Y")) {
                yn = "현주소";
            } else {
                yn = " 주소";
            }
            Date date = address.getPk().getHouseMovementReportDate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            addresses.add(new ResidentRegistrationAddress(yn, address.getHouseMovementAddress(), format.format(date)));
        }

        List<ResidentRegistrationInfo> contents = new ArrayList<>();
        List<HouseholdCompositionResident> residents = certificateService.getHouseholdCompositionResidents(household.getHouseholdSerialNumber());

        for (HouseholdCompositionResident resident : residents) {
            Date date = resident.getReportDate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            contents.add(new ResidentRegistrationInfo(
                    resident.getHouseholdRelationshipCode(), resident.getResident().getName(),
                    resident.getResident().getResidentRegistrationNumber(), format.format(date),
                    resident.getHouseholdCompositionChangeReasonCode()));
        }

        Date reportDate = certificate.getCertificateIssueDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");

        model.addAttribute("certificate", certificate);
        model.addAttribute("reportDate", format.format(reportDate));
        model.addAttribute("name", certificate.getResident().getName());
        model.addAttribute("household", household);
        model.addAttribute("addresses", addresses);
        model.addAttribute("contents", contents);

        return "certificate/residentRegistration";
    }
}

package com.nhnacademy.jpa.controller;

import com.nhnacademy.jpa.dto.familyRelationship.RelationshipDto;
import com.nhnacademy.jpa.dto.familyRelationship.RelationshipRegisterRequest;
import com.nhnacademy.jpa.dto.familyRelationship.RelationshipUpdateRequest;
import com.nhnacademy.jpa.service.FamilyRelationshipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/residents/{serialNumber}/relationship")
public class FamilyRelationshipController {

    private final FamilyRelationshipService familyRelationshipService;

    public FamilyRelationshipController(FamilyRelationshipService familyRelationshipService) {
        this.familyRelationshipService = familyRelationshipService;
    }

    @GetMapping
    public ResponseEntity<List<RelationshipDto>> getRelationship(@PathVariable Long serialNumber) {
        List<RelationshipDto> relationshipDtoList = familyRelationshipService.getRelationships(serialNumber);
        return new ResponseEntity<>(relationshipDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RelationshipDto> registerRelationship(@PathVariable Long serialNumber,
                                                                @RequestBody RelationshipRegisterRequest request) {
        RelationshipDto relationshipDto = familyRelationshipService.registerRelationshipAndGet(serialNumber, request);
        return new ResponseEntity<>(relationshipDto, HttpStatus.CREATED);
    }

    @PutMapping("/{familySerialNumber}")
    public ResponseEntity<RelationshipDto> modifyRelationship(@PathVariable Long serialNumber,
                                                              @PathVariable Long familySerialNumber,
                                                              @RequestBody RelationshipUpdateRequest request) {
        familyRelationshipService.modifyRelationship(serialNumber, familySerialNumber, request);
        RelationshipDto relationshipDto = familyRelationshipService.getRelationship(serialNumber, familySerialNumber);
        return new ResponseEntity<>(relationshipDto, HttpStatus.OK);
    }


    @DeleteMapping("/{familySerialNumber}")
    public ResponseEntity<Void> deleteRelationship(@PathVariable Long serialNumber,
                                                   @PathVariable Long familySerialNumber) {
        familyRelationshipService.deleteRelationship(serialNumber, familySerialNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

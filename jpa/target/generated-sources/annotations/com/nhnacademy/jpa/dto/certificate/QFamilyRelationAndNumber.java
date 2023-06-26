package com.nhnacademy.jpa.dto.certificate;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.nhnacademy.jpa.dto.certificate.QFamilyRelationAndNumber is a Querydsl Projection type for FamilyRelationAndNumber
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QFamilyRelationAndNumber extends ConstructorExpression<FamilyRelationAndNumber> {

    private static final long serialVersionUID = 1929734110L;

    public QFamilyRelationAndNumber(com.querydsl.core.types.Expression<Long> familyResidentSerialNumber, com.querydsl.core.types.Expression<String> familyRelationshipCode) {
        super(FamilyRelationAndNumber.class, new Class<?>[]{long.class, String.class}, familyResidentSerialNumber, familyRelationshipCode);
    }

}


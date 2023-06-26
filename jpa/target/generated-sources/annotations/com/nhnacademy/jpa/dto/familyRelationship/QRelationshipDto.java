package com.nhnacademy.jpa.dto.familyRelationship;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.nhnacademy.jpa.dto.familyRelationship.QRelationshipDto is a Querydsl Projection type for RelationshipDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QRelationshipDto extends ConstructorExpression<RelationshipDto> {

    private static final long serialVersionUID = -1504383328L;

    public QRelationshipDto(com.querydsl.core.types.Expression<Long> familyResidentSerialNumber, com.querydsl.core.types.Expression<Long> baseResidentSerialNumber, com.querydsl.core.types.Expression<String> familyRelationshipCode) {
        super(RelationshipDto.class, new Class<?>[]{long.class, long.class, String.class}, familyResidentSerialNumber, baseResidentSerialNumber, familyRelationshipCode);
    }

}


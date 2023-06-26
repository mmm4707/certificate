package com.nhnacademy.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFamilyRelationship is a Querydsl query type for FamilyRelationship
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFamilyRelationship extends EntityPathBase<FamilyRelationship> {

    private static final long serialVersionUID = 428039243L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFamilyRelationship familyRelationship = new QFamilyRelationship("familyRelationship");

    public final QResident baseResident;

    public final StringPath familyRelationshipCode = createString("familyRelationshipCode");

    public final QResident familyResident;

    public final QFamilyRelationship_Pk pk;

    public QFamilyRelationship(String variable) {
        this(FamilyRelationship.class, forVariable(variable), INITS);
    }

    public QFamilyRelationship(Path<? extends FamilyRelationship> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFamilyRelationship(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFamilyRelationship(PathMetadata metadata, PathInits inits) {
        this(FamilyRelationship.class, metadata, inits);
    }

    public QFamilyRelationship(Class<? extends FamilyRelationship> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.baseResident = inits.isInitialized("baseResident") ? new QResident(forProperty("baseResident")) : null;
        this.familyResident = inits.isInitialized("familyResident") ? new QResident(forProperty("familyResident")) : null;
        this.pk = inits.isInitialized("pk") ? new QFamilyRelationship_Pk(forProperty("pk")) : null;
    }

}


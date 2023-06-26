package com.nhnacademy.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFamilyRelationship_Pk is a Querydsl query type for Pk
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QFamilyRelationship_Pk extends BeanPath<FamilyRelationship.Pk> {

    private static final long serialVersionUID = -40766818L;

    public static final QFamilyRelationship_Pk pk = new QFamilyRelationship_Pk("pk");

    public final NumberPath<Long> baseResidentSerialNumber = createNumber("baseResidentSerialNumber", Long.class);

    public final NumberPath<Long> familyResidentSerialNumber = createNumber("familyResidentSerialNumber", Long.class);

    public QFamilyRelationship_Pk(String variable) {
        super(FamilyRelationship.Pk.class, forVariable(variable));
    }

    public QFamilyRelationship_Pk(Path<? extends FamilyRelationship.Pk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFamilyRelationship_Pk(PathMetadata metadata) {
        super(FamilyRelationship.Pk.class, metadata);
    }

}


package com.nhnacademy.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHouseholdCompositionResident_Pk is a Querydsl query type for Pk
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QHouseholdCompositionResident_Pk extends BeanPath<HouseholdCompositionResident.Pk> {

    private static final long serialVersionUID = 1914208767L;

    public static final QHouseholdCompositionResident_Pk pk = new QHouseholdCompositionResident_Pk("pk");

    public final NumberPath<Long> householdSerialNumber = createNumber("householdSerialNumber", Long.class);

    public final NumberPath<Long> residentSerialNumber = createNumber("residentSerialNumber", Long.class);

    public QHouseholdCompositionResident_Pk(String variable) {
        super(HouseholdCompositionResident.Pk.class, forVariable(variable));
    }

    public QHouseholdCompositionResident_Pk(Path<? extends HouseholdCompositionResident.Pk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHouseholdCompositionResident_Pk(PathMetadata metadata) {
        super(HouseholdCompositionResident.Pk.class, metadata);
    }

}


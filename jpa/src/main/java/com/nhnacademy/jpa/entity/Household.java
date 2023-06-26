package com.nhnacademy.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "household")
public class Household {

    @Id
    @Column(name = "household_serial_number")
    private Long householdSerialNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "household_resident_serial_number")
    private Resident resident;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @Column(name = "household_composition_date")
    private Date householdCompositionDate;

    @Column(name = "household_composition_reason_code")
    private String householdCompositionReasonCode;

    @Column(name = "current_house_movement_address")
    private String currentHouseMovementAddress;

}

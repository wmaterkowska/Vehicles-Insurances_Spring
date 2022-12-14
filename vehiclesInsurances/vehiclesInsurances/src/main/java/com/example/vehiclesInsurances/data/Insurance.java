package com.example.vehiclesInsurances.data;

import jakarta.persistence.*;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "insurances")
public class Insurance {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    Long id; // - id bigint PRIMARY KEY NOT NULL


    @Column(insertable=false, updatable=false)
    Long vehicle_id; //- vehicle_id bigint NOT NULL REFERENCES (vehicles.id)

    @Column
    String insurer; //- insurer text NOT NULL //nazwa towarzystwa ubezpieczeniowego z którego pochodzi dana oferta

    @Column
    float price; //- price float NOT NULL

    @Column
    String additionalData; // - ... // pozostałe dane o ofercie ubezpieczeniowej

    @Column
    LocalDateTime insertTime; //- insert_time timestamp NOT NULL

    @ManyToOne (targetEntity = Vehicle.class)
    @JoinColumn( name = "vehicle_id", referencedColumnName ="id", nullable = false)
    Vehicle vehicle;

}

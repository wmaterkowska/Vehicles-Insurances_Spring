package com.example.vehiclesInsurances.data;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "insurance_offers")
public class Insurance {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    long id; // - id bigint PRIMARY KEY NOT NULL


    @Column
    long vehicleId; //- vehicle_id bigint NOT NULL REFERENCES (vehicles.id)

    @Column
    String insurer; //- insurer text NOT NULL //nazwa towarzystwa ubezpieczeniowego z którego pochodzi dana oferta

    @Column
    float price; //- price float NOT NULL

    @Column
    String additionalData; // - ... // pozostałe dane o ofercie ubezpieczeniowej

    @Column
    LocalDateTime insertTime; //- insert_time timestamp NOT NULL

}

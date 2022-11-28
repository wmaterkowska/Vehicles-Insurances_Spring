package com.example.vehiclesInsurances.data;

import jakarta.persistence.*;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "vehicles")
public class Vehicle {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    @NotNull
    @Column
    String login; //- login text NOT NULL REFERENCES(users.login)

    @Column
    String brand;

    @Column
    String model;

    @Column
    String additionalData;

    @NotNull
    @Column
    LocalDateTime insertTime; //- insert_time timestamp NOT NULL

    @OneToMany(mappedBy = "vehicleId" )
    List<Insurance> insurances;

}

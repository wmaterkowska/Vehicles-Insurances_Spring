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
    private Long id;

    @NotNull
    @Column(insertable=false, updatable=false)
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

    @ManyToOne (targetEntity = User.class)
    @JoinColumn( name = "login",referencedColumnName = "login", nullable = false )
    User user;

    @OneToMany(mappedBy = "vehicle", targetEntity = Insurance.class)
    List<Insurance> insurances;

}

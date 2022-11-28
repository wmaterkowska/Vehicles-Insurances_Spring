package com.example.vehiclesInsurances.data;

import jakarta.persistence.*;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table( name = "users")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id; //- id bigint PRIMARY KEY NOT NULL

    @Column
    String nick; //- nick text NOT NULL

    @Column
    String login; //- login text NOT NULL

    @Column
    String password; //- password text NOT NULL

    @Column
    String additionalData; //- ... // pozostałe dane o użytkowniku

    @Column
    LocalDateTime insertTime; //- insert_time timestamp NOT NULL DEFAULT now()

    @OneToMany(mappedBy = "login")
    List<Vehicle> vehicles;
}

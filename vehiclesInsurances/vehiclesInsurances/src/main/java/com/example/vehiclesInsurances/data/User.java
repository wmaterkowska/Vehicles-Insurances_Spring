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
    private Long id; //- id bigint PRIMARY KEY NOT NULL

    @Column
    private String nick; //- nick text NOT NULL

    @Column
    @NotNull
    private String login; //- login text NOT NULL

    @Column
    @NotNull
    private String password; //- password text NOT NULL

    @Column
    private String additionalData; //- ... // pozostałe dane o użytkowniku

    @Column
    @NotNull
    private LocalDateTime insertTime; //- insert_time timestamp NOT NULL DEFAULT now()

    @OneToMany(mappedBy = "login")
    private List<Vehicle> vehicles;
}

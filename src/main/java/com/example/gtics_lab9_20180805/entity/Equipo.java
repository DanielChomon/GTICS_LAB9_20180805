package com.example.gtics_lab9_20180805.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipo")
@Getter
@Setter
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipo", nullable = false)
    private Integer idEquipo;

    @Column(name = "nombreEquipo", nullable = false)
    private String nombreEquipo;

    @Column(name = "colorEquipo", nullable = false)
    private String colorEquipo;

    @Column(name = "mascota", nullable = false)
    private String mascota;

}

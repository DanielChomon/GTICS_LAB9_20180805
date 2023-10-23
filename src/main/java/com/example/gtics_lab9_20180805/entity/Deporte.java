package com.example.gtics_lab9_20180805.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "deporte")
@Getter
@Setter
public class Deporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDeporte", nullable = false)
    private Integer idDeporte;

    @Column(name = "nombreDeporte", nullable = false)
    private String nombreDeporte;

    @Column(name = "pesoDeporte")
    private Integer pesoDeporte;

}

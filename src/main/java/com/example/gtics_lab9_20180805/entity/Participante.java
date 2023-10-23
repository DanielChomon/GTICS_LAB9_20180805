package com.example.gtics_lab9_20180805.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "participante")
@Getter
@Setter
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idParticipante", nullable = false)
    private Integer idParticipante;

    @ManyToOne
    @JoinColumn(name = "equipo", nullable = false)
    private Equipo equipo;

    @Column(name = "carrera")
    private String carrera;

    @Column(name = "codigo", length = 8)
    private BigDecimal codigo;

    @Column(name = "tipoParticipante")
    private String tipoParticipante;
}

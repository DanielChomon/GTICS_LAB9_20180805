package com.example.gtics_lab9_20180805.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "historialPartidos")
@Getter
@Setter
public class Historialpartido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHistorialPartidos", nullable = false)
    private Integer idHistorialPartidos;

    @ManyToOne
    @JoinColumn(name = "partido_idpartido", nullable = false)
    private Partido idPartido;

    @ManyToOne
    @JoinColumn(name = "deporte_iddeporte", nullable = false)
    private Deporte idDeporte;

    @Column(name = "horaFecha")
    private Date horaFecha;

}

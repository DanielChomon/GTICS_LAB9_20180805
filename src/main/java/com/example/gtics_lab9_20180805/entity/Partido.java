package com.example.gtics_lab9_20180805.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "partido")
@Getter
@Setter
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPartido", nullable = false)
    private Integer idPartido;

    @ManyToOne
    @JoinColumn(name = "equipoA", nullable = false)
    private Equipo equipoA;

    @ManyToOne
    @JoinColumn(name = "equipoB", nullable = false)
    private Equipo equipoB;

    @Column(name = "scoreA")
    private Integer scoreA;

    @Column(name = "scoreB")
    private Integer scoreB;

}

package com.example.gtics_lab9_20180805.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "participantespartido")
@Getter
@Setter
@JsonIgnoreProperties(value = {"idPartido","horaFecha"})
public class Participantepartido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idParticipantesPartido")
    private Integer idParticipantesPartido;

    @ManyToOne
    @JoinColumn(name = "partido_idPartido", nullable = false)
    private Partido idPartido;

    @ManyToOne
    @JoinColumn(name = "participante_idParticipante", nullable = false)
    private Participante idParticipante;

    @Column(name = "horaFecha")
    private Date horaFecha;
}

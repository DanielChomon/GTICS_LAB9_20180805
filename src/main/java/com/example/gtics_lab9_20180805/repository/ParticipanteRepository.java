package com.example.gtics_lab9_20180805.repository;

import com.example.gtics_lab9_20180805.entity.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Integer> {

    @Query(value ="select * from participante where equipo =?1", nativeQuery = true )
    List<Participante> listaParticipantesEquipo(int equipo);
}

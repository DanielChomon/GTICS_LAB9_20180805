package com.example.gtics_lab9_20180805.repository;

import com.example.gtics_lab9_20180805.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository  extends JpaRepository<Equipo, Integer> {
}

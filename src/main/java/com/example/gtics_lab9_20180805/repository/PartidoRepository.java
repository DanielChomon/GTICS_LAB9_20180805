package com.example.gtics_lab9_20180805.repository;

import com.example.gtics_lab9_20180805.entity.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {

}

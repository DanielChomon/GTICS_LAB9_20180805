package com.example.gtics_lab9_20180805.repository;

import com.example.gtics_lab9_20180805.entity.Deporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeporteRepository extends JpaRepository<Deporte,Integer> {

}

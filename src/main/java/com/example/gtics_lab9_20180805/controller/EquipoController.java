package com.example.gtics_lab9_20180805.controller;

import com.example.gtics_lab9_20180805.entity.Equipo;
import com.example.gtics_lab9_20180805.repository.EquipoRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/equipo")
public class EquipoController {

    final EquipoRepository equipoRepository;

    public EquipoController(EquipoRepository equipoRepository){
        this.equipoRepository=equipoRepository;
    }

    @PostMapping(value = "registro")
    public ResponseEntity<HashMap<String, Object>> guardarEquipo(
            @RequestBody Equipo equipo,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {

        HashMap<String, Object> responseJson = new HashMap<>();

        equipoRepository.save(equipo);
        if (fetchId) {
            responseJson.put("id", equipo.getIdEquipo());
        }
        responseJson.put("estado", "creado");
        return ResponseEntity.status(HttpStatus.OK).body(responseJson);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, String>> gestionExceptionC(HttpServletRequest request) {
        HashMap<String, String> responseMap3 = new HashMap<>();
        if (request.getMethod().equals("POST") || request.getMethod().equals("PUT")) {
            responseMap3.put("estado", "error");
            responseMap3.put("msg", "Se debe incluir equipo");
        }
        return ResponseEntity.badRequest().body(responseMap3);
    }
}

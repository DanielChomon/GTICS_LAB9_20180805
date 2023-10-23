package com.example.gtics_lab9_20180805.controller;

import com.example.gtics_lab9_20180805.entity.Deporte;
import com.example.gtics_lab9_20180805.repository.DeporteRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/deporte")
public class DeporteController {

    final DeporteRepository deporteRepository;

    public DeporteController(DeporteRepository deporteRepository){
        this.deporteRepository=deporteRepository;
    }

    @PostMapping(value = "registro")
    public ResponseEntity<HashMap<String, Object>> guardarDeporte(
            @RequestBody Deporte deporte,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {

        HashMap<String, Object> responseJson = new HashMap<>();

        deporteRepository.save(deporte);
        if (fetchId) {
            responseJson.put("id", deporte.getIdDeporte());
        }
        responseJson.put("estado", "creado");
        return ResponseEntity.status(HttpStatus.OK).body(responseJson);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, String>> gestionExceptionA(HttpServletRequest request) {
        HashMap<String, String> responseMap = new HashMap<>();
        if (request.getMethod().equals("POST") || request.getMethod().equals("PUT")) {
            responseMap.put("estado", "error");
            responseMap.put("msg", "Se debe incluir deporte");
        }
        return ResponseEntity.badRequest().body(responseMap);
    }
}

package com.example.gtics_lab9_20180805.controller;

import com.example.gtics_lab9_20180805.entity.Participante;
import com.example.gtics_lab9_20180805.repository.ParticipanteRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/participante")
public class ParticipanteController {

    final ParticipanteRepository participanteRepository;

    public ParticipanteController(ParticipanteRepository participanteRepository){
        this.participanteRepository=participanteRepository;
    }

    @PostMapping(value = "registro")
    public ResponseEntity<HashMap<String, Object>> guardarParticipante(
            @RequestBody Participante participante,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {

        HashMap<String, Object> responseJson = new HashMap<>();

        participanteRepository.save(participante);
        if (fetchId) {
            responseJson.put("id", participante.getIdParticipante());
        }
        responseJson.put("estado", "creado");
        return ResponseEntity.status(HttpStatus.OK).body(responseJson);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, String>> gestionExceptionB(HttpServletRequest request) {
        HashMap<String, String> responseMap2 = new HashMap<>();
        if (request.getMethod().equals("POST") || request.getMethod().equals("PUT")) {
            responseMap2.put("estado", "error");
            responseMap2.put("msg", "Se debe incluir participante");
        }
        return ResponseEntity.badRequest().body(responseMap2);
    }
}

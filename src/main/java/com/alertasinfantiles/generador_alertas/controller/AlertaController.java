package com.alertasinfantiles.generador_alertas.controller;

import com.alertasinfantiles.generador_alertas.kafka.AlertaProducer;
import com.alertasinfantiles.generador_alertas.model.AlertaInfantil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/alertas")
@CrossOrigin(origins = "*")
public class AlertaController {

    @Autowired
    private AlertaProducer alertaProducer;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarAlerta(@RequestBody AlertaInfantil alerta) {
        alerta.setFechaAlerta(LocalDateTime.now());
        alertaProducer.enviarAlerta(alerta);
        return ResponseEntity.ok("Alerta enviada a Kafka: " + alerta);
    }
}

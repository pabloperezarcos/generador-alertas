package com.alertasinfantiles.generador_alertas.controller;

import com.alertasinfantiles.generador_alertas.kafka.AlertaProducer;
import com.alertasinfantiles.generador_alertas.model.AlertaInfantil;
//import com.alertasinfantiles.generador_alertas.model.AlertaGraveInfantil;
import com.alertasinfantiles.generador_alertas.service.AlertaService;
import com.alertasinfantiles.generador_alertas.service.AlertaGraveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/alertas")
@CrossOrigin(origins = "*")
public class AlertaController {

    @Autowired
    private AlertaProducer alertaProducer;

    @Autowired
    private AlertaService alertaService;

    @Autowired
    private AlertaGraveService alertaGraveService;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarAlerta(@RequestBody AlertaInfantil alerta) {
        alerta.setFechaAlerta(Instant.now());
        alertaProducer.enviarAlerta(alerta);
        return ResponseEntity.ok("Alerta enviada a Kafka: " + alerta);
    }

    /**
     * Obtiene todas las alertas (infantiles y graves) en una sola respuesta.
     */
    @GetMapping("/enviar/todas")
    public ResponseEntity<List<Object>> obtenerTodasLasAlertas() {
        List<Object> todasLasAlertas = new ArrayList<>();
        todasLasAlertas.addAll(alertaService.obtenerTodas()); // Alertas infantiles
        todasLasAlertas.addAll(alertaGraveService.obtenerTodas()); // Alertas graves infantiles
        return ResponseEntity.ok(todasLasAlertas);
    }

}

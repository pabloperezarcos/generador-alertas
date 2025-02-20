package com.alertasinfantiles.generador_alertas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "alertas_graves_infantiles")
@Data
public class AlertaGraveInfantil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlerta;

    @Column(nullable = false)
    private String nombrePaciente;

    @Column(nullable = false)
    private String tipoAlerta;

    @Column(nullable = false)
    private String nivelAlerta = "Alta"; // Este valor siempre será "Alta"

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Instant fechaAlerta = Instant.now();
}
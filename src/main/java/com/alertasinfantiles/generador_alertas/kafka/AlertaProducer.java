package com.alertasinfantiles.generador_alertas.kafka;

import com.alertasinfantiles.generador_alertas.model.AlertaInfantil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AlertaProducer {

    private static final String TOPICO = "alertas_infantiles";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void enviarAlerta(AlertaInfantil alerta) {
        kafkaTemplate.send(TOPICO, alerta);
    }
}

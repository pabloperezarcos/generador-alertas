package com.alertasinfantiles.generador_alertas.service;

import com.alertasinfantiles.generador_alertas.model.AlertaGraveInfantil;
import com.alertasinfantiles.generador_alertas.repository.AlertaGraveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaGraveService {

    @Autowired
    private AlertaGraveRepository alertaGraveRepository;

    public List<AlertaGraveInfantil> obtenerTodas() {
        return alertaGraveRepository.findAll(); 
    }
}

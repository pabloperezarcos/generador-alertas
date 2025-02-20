package com.alertasinfantiles.generador_alertas.service;

import com.alertasinfantiles.generador_alertas.model.AlertaInfantil;
import com.alertasinfantiles.generador_alertas.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaGraveService {

    @Autowired
    private AlertaRepository alertaRepository;

    public List<AlertaInfantil> obtenerTodas() {
        return alertaRepository.findAll(); 
    }
}

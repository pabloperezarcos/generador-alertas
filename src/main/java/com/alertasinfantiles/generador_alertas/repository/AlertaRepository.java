package com.alertasinfantiles.generador_alertas.repository;

import com.alertasinfantiles.generador_alertas.model.AlertaInfantil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaRepository extends JpaRepository<AlertaInfantil, Long> {
}

package com.alertasinfantiles.generador_alertas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.alertasinfantiles.generador_alertas.model.AlertaGraveInfantil;

@Repository
public interface AlertaGraveRepository extends JpaRepository<AlertaGraveInfantil, Long> {
}
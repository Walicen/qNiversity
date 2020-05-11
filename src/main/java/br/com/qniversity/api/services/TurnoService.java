package br.com.qniversity.api.services;

import br.com.qniversity.api.models.Turno;

import java.util.List;
import java.util.Optional;

public interface TurnoService {

    List<Turno> findAll();

    Optional<Turno> findById(Long id);

    void save(Turno turno);
}

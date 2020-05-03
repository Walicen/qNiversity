package br.com.qniversity.api.services;

import br.com.qniversity.api.models.Turno;

import java.util.List;

public interface TurnoService {

    List<Turno> findAll();

    void save(Turno turno);
}

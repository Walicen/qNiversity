package br.com.qniversity.api.services;

import br.com.qniversity.api.models.Turma;

import java.util.List;
import java.util.Optional;

public interface TurmaService {

    List<Turma> findAll();

    Optional<Turma> findById(Long id);

    Optional<Turma> findByCodigo(String codigo);

    void save(Turma turma);
}

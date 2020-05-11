package br.com.qniversity.api.services;

import br.com.qniversity.api.models.Turma;

import java.util.List;
import java.util.Optional;

public interface TurmaService {

    List<Turma> findAll();

    List<Turma> findByCurso(Long cursoId);

    Optional<Turma> findById(Long turmaId);

    Optional<Turma> findByCodigo(String codigo);

    Optional<Turma> findByNome(String nome);

    void save(Turma turma);


}

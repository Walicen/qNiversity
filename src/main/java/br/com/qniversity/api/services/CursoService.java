package br.com.qniversity.api.services;

import br.com.qniversity.api.models.Curso;

import java.util.List;
import java.util.Optional;


public interface CursoService {

    Optional<Curso> findByNome(String nome);

    Optional<Curso> findById(Long id);

    List<Curso> findAll();

    void save(Curso curso);
}

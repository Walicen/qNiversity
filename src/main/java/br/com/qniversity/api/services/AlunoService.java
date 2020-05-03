package br.com.qniversity.api.services;

import br.com.qniversity.api.models.Aluno;

import java.util.List;
import java.util.Optional;

public interface AlunoService {

    Optional<Aluno> findByEmail(String email);
    Optional<Aluno> findByTurmaId(Long id);

    List<Aluno> findAll();

    void save(Aluno aluno);
}

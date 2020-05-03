package br.com.qniversity.api.services;

import br.com.qniversity.api.models.Turma;

import java.util.List;

public interface TurmaService {

    List<Turma> findAll();

    void save(Turma turma);
}

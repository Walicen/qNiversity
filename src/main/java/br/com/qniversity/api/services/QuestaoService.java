package br.com.qniversity.api.services;

import br.com.qniversity.api.models.Questao;

import java.util.List;

public interface QuestaoService {

    List<Questao> findAll();

    void save(Questao questao);
}

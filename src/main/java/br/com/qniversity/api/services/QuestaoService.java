package br.com.qniversity.api.services;

import br.com.qniversity.api.models.Questao;

import java.util.List;
import java.util.Optional;

public interface QuestaoService {

    List<Questao> findAll();

    Optional<Questao> findById(Long i);

    void save(Questao questao);
}

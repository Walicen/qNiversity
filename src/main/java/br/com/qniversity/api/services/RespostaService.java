package br.com.qniversity.api.services;

import br.com.qniversity.api.models.Resposta;

import java.util.List;
import java.util.Optional;

public interface RespostaService {

    List<Resposta> findAll();

    Optional<Resposta> findById(Long i);

    void save(Resposta resposta);

    void saveAll(List<Resposta> respostas);
}

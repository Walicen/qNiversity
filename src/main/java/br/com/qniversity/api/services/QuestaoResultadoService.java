package br.com.qniversity.api.services;

import br.com.qniversity.api.models.Questao;
import br.com.qniversity.api.models.QuestaoResultado;

import java.util.List;
import java.util.Optional;

public interface QuestaoResultadoService {

    List<QuestaoResultado> findAll();

    Optional<QuestaoResultado> findById(Long i);

    List<QuestaoResultado> findByQuizId(Long quizId);

    List<QuestaoResultado> findByAlunoId(Long alunoId);

    void save(QuestaoResultado questaoResultado);
}

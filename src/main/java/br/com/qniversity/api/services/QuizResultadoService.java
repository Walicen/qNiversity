package br.com.qniversity.api.services;

import br.com.qniversity.api.models.QuizResultado;

import java.util.List;

public interface QuizResultadoService {

    List<QuizResultado> findAll();

    List<QuizResultado> findByQuizId(Long quizId);

    List<QuizResultado> findByAlunoId(Long alunoId);

    void save(QuizResultado quizResultado);
}

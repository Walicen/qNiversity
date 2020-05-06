package br.com.qniversity.api.services;

import br.com.qniversity.api.models.Quiz;

import java.util.List;

public interface QuizService {

    List<Quiz> findAll();

    void save(Quiz quiz);
}

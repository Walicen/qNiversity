package br.com.qniversity.api.services.impl;

import br.com.qniversity.api.models.Quiz;
import br.com.qniversity.api.repositories.QuizRepository;
import br.com.qniversity.api.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public List<Quiz> findAll() {
        return this.quizRepository.findAll();
    }

    @Override
    public void save(Quiz quiz) {
        this.quizRepository.save(quiz);
    }
}

package br.com.qniversity.api.services.impl;

import br.com.qniversity.api.models.QuizResultado;
import br.com.qniversity.api.repositories.QuizResultadoRepository;
import br.com.qniversity.api.services.QuizResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizResultadoServiceImpl implements QuizResultadoService {

    @Autowired
    private QuizResultadoRepository repository;

    @Override
    public List<QuizResultado> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<QuizResultado> findByQuizId(Long quizId) {
        return this.repository.findByQuiz_Id(quizId);
    }

    @Override
    public List<QuizResultado> findByAlunoId(Long alunoId) {
        return this.repository.findByAluno_Id(alunoId);
    }

    @Override
    public void save(QuizResultado quizResultado) {
        this.repository.save(quizResultado);
    }
}

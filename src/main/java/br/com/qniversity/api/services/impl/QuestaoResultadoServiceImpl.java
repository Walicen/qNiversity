package br.com.qniversity.api.services.impl;

import br.com.qniversity.api.models.QuestaoResultado;
import br.com.qniversity.api.repositories.QuestaoResultadoRepository;
import br.com.qniversity.api.services.QuestaoResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestaoResultadoServiceImpl implements QuestaoResultadoService {

    @Autowired
    private QuestaoResultadoRepository questaoResultadoRepository;

    @Override
    public List<QuestaoResultado> findAll() {
        return this.questaoResultadoRepository.findAll();
    }

    @Override
    public Optional<QuestaoResultado> findById(Long i) {
        return this.questaoResultadoRepository.findById(i);
    }

    @Override
    public List<QuestaoResultado> findByQuizId(Long quizId) {
        return this.questaoResultadoRepository.findByQuizResultado_Quiz_Id(quizId);
    }

    @Override
    public List<QuestaoResultado> findByAlunoId(Long alunoId) {
        return this.questaoResultadoRepository.findByQuizResultado_Aluno_Id(alunoId);
    }

    @Override
    public void save(QuestaoResultado questaoResultado) {
        this.questaoResultadoRepository.save(questaoResultado);
    }
}

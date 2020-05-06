package br.com.qniversity.api.services.impl;

import br.com.qniversity.api.models.Questao;
import br.com.qniversity.api.repositories.QuestaoRepository;
import br.com.qniversity.api.services.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestaoServiceImpl implements QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;

    @Override
    public List<Questao> findAll() {
        return this.questaoRepository.findAll();
    }

    @Override
    public Optional<Questao> findById(Long i) {
        return this.questaoRepository.findById(i);
    }

    @Override
    public void save(Questao questao) {
        this.questaoRepository.save(questao);
    }
}

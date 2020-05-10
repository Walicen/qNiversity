package br.com.qniversity.api.services.impl;

import br.com.qniversity.api.models.Resposta;
import br.com.qniversity.api.repositories.RespostaRepository;
import br.com.qniversity.api.services.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespostaServiceImpl implements RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Override
    public List<Resposta> findAll() {
        return this.respostaRepository.findAll();
    }

    @Override
    public Optional<Resposta> findById(Long i) {
        return this.respostaRepository.findById(i);
    }

    @Override
    public void save(Resposta resposta) {
        this.respostaRepository.save(resposta);
    }

    @Override
    public void saveAll(List<Resposta> respostas) {
        this.respostaRepository.saveAll(respostas);
    }
}

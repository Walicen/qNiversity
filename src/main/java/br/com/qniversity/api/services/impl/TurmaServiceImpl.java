package br.com.qniversity.api.services.impl;

import br.com.qniversity.api.models.Turma;
import br.com.qniversity.api.repositories.TurmaRepository;
import br.com.qniversity.api.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaServiceImpl implements TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public List<Turma> findAll() {
        return this.turmaRepository.findAll();
    }

    @Override
    public Optional<Turma> findById(Long id) {
        return this.turmaRepository.findById(id);
    }

    @Override
    public Optional<Turma> findByCodigo(String codigo) {
        return this.turmaRepository.findByCodigo(codigo);
    }

    @Override
    public void save(Turma turma) {
        this.turmaRepository.save(turma);
    }
}

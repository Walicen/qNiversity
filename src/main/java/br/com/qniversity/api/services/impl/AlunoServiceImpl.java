package br.com.qniversity.api.services.impl;

import br.com.qniversity.api.models.Aluno;
import br.com.qniversity.api.models.Usuario;
import br.com.qniversity.api.repositories.AlunoRepository;
import br.com.qniversity.api.repositories.UserRepository;
import br.com.qniversity.api.services.AlunoService;
import br.com.qniversity.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;


    @Override
    public Optional<Aluno> findByEmail(String email) {
        return Optional.ofNullable(this.alunoRepository.findByEmail(email));
    }

    @Override
    public Optional<Aluno> findByTurmaId(Long id) {
        return Optional.ofNullable(this.alunoRepository.findByTurma_Id(id));
    }

    @Override
    public List<Aluno> findAll() {
        return this.alunoRepository.findAll();
    }

    @Override
    public void save(Aluno aluno) {
        this.alunoRepository.save(aluno);
    }
}

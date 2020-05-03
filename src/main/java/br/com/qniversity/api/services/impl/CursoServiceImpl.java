package br.com.qniversity.api.services.impl;

import br.com.qniversity.api.models.Curso;
import br.com.qniversity.api.models.Turma;
import br.com.qniversity.api.repositories.CursoRepository;
import br.com.qniversity.api.repositories.TurmaRepository;
import br.com.qniversity.api.services.CursoService;
import br.com.qniversity.api.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Optional<Curso> findByNome(String nome) {
        return Optional.ofNullable(this.cursoRepository.findByNome(nome));
    }

    @Override
    public List<Curso> findAll() {
        return this.cursoRepository.findAll();
    }

    @Override
    public void save(Curso curso) {
        this.cursoRepository.save(curso);
    }
}

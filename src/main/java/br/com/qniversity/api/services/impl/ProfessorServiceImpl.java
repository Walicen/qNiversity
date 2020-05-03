package br.com.qniversity.api.services.impl;

import br.com.qniversity.api.models.Professor;
import br.com.qniversity.api.repositories.ProfessorRepository;
import br.com.qniversity.api.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;


    @Override
    public Optional<Professor> findByEmail(String email) {
        return Optional.ofNullable(this.professorRepository.findByEmail(email));
    }


    @Override
    public List<Professor> findAll() {
        return this.professorRepository.findAll();
    }

    @Override
    public void save(Professor professor) {
        this.professorRepository.save(professor);
    }
}

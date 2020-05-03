package br.com.qniversity.api.services;

import br.com.qniversity.api.models.Professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorService {

    Optional<Professor> findByEmail(String email);


    List<Professor> findAll();

    void save(Professor professor);
}

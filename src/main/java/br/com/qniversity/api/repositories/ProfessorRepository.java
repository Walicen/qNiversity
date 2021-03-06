package br.com.qniversity.api.repositories;

import br.com.qniversity.api.models.Aluno;
import br.com.qniversity.api.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    public Professor findByEmail(String email);

}

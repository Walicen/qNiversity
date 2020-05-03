package br.com.qniversity.api.repositories;

import br.com.qniversity.api.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    public Aluno findByEmail(String email);
    public Aluno findByTurma_Id(Long id);

}

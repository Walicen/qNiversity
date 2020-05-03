package br.com.qniversity.api.repositories;

import br.com.qniversity.api.models.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {


}

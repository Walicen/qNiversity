package br.com.qniversity.api.repositories;

import br.com.qniversity.api.models.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

    Optional<Turma> findByCodigo(String codigo);

    List<Turma> findByCurso_Id(Long cursoId);

    Optional<Turma> findByNome(String nome);

}

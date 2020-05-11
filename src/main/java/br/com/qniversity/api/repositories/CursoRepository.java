package br.com.qniversity.api.repositories;

import br.com.qniversity.api.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    Optional<Curso> findByNome(String nome);

    Optional<Curso> findById(Long id);

}

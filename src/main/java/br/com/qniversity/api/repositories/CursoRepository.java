package br.com.qniversity.api.repositories;

import br.com.qniversity.api.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNome(String nome);

}

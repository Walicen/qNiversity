package br.com.qniversity.api.repositories;

import br.com.qniversity.api.models.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {

    public List<Resultado> findByAluno_Id(Long alunoId);

    public List<Resultado> findByQuiz_Id(Long quizId);


}

package br.com.qniversity.api.repositories;

import br.com.qniversity.api.models.QuizResultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizResultadoRepository extends JpaRepository<QuizResultado, Long> {

    public List<QuizResultado> findByQuiz_Id(Long id);

    public List<QuizResultado> findByAluno_Id(Long id);

}

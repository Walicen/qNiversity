package br.com.qniversity.api.repositories;

import br.com.qniversity.api.models.QuestaoResultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestaoResultadoRepository extends JpaRepository<QuestaoResultado, Long> {


    public List<QuestaoResultado> findByQuizResultado_Quiz_Id(Long quizId);

    public List<QuestaoResultado> findByQuizResultado_Aluno_Id(Long alunoId);

    public List<QuestaoResultado> findByQuizResultado_Quiz_IdAndQuizResultado_Aluno_Id(Long quizId, Long alunoId);

}

package br.com.qniversity.api.models.dtos;

import br.com.qniversity.api.models.Aluno;
import br.com.qniversity.api.models.Quiz;
import br.com.qniversity.api.models.QuizResultado;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QuizResultadoDTO {

    private Long id;

    private List<QuestaoResultadoDTO> questaoResultados = new ArrayList<>(0);

    private int tentativa;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;

    private Long quizId;
    private Long alunoId;

    public QuizResultadoDTO() {
    }

    public QuizResultadoDTO(Long id, List<QuestaoResultadoDTO> questaoResultadoDTOList, int tentativa, LocalDateTime dataCriacao, Long quizId, Long alunoId) {
        this.id = id;
        this.questaoResultados = questaoResultadoDTOList;
        this.tentativa = tentativa;
        this.dataCriacao = dataCriacao;
        this.quizId = quizId;
        this.alunoId = alunoId;
    }

    public Long getId() {
        return id;
    }

    public List<QuestaoResultadoDTO> getQuestaoResultados() {
        return questaoResultados;
    }

    public void setQuestaoResultados(List<QuestaoResultadoDTO> questaoResultados) {
        this.questaoResultados = questaoResultados;
    }

    public int getTentativa() {
        return tentativa;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Long getQuizId() {
        return quizId;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public QuizResultado converter(Aluno aluno, Quiz quiz) {
        return new QuizResultado(this.tentativa, quiz, aluno);
    }
}

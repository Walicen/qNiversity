package br.com.qniversity.api.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class QuizResultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "quizResultado")
    private List<QuestaoResultado> questaoResultados = new ArrayList<>(0);

    private int tentativa;

    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;


    public QuizResultado() {
    }

    public QuizResultado(int tentativa, Quiz quiz, Aluno aluno) {
        this.tentativa = tentativa;
        this.quiz = quiz;
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTentativa() {
        return tentativa;
    }

    public void setTentativa(int tentativa) {
        this.tentativa = tentativa;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<QuestaoResultado> getQuestaoResultados() {
        return questaoResultados;
    }

    public void setQuestaoResultados(List<QuestaoResultado> questaoResultados) {
        this.questaoResultados = questaoResultados;
    }

    @PrePersist
    private void prePersist() {
        dataCriacao = LocalDateTime.now();
    }
}

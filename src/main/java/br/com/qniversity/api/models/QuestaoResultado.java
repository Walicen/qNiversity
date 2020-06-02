package br.com.qniversity.api.models;

import javax.persistence.*;

@Entity
public class QuestaoResultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "quiz_resultado_id", nullable = false)
    private QuizResultado quizResultado;

    private String questao;

    private String respostaCorreta;

    private String respostaSelecionada;

    private boolean correta;

    public QuestaoResultado() {
    }

    public QuestaoResultado(QuizResultado quizResultado, String questao, String respostaCorreta, String respostaSelecionada, boolean correta) {
        this.quizResultado = quizResultado;
        this.questao = questao;
        this.respostaCorreta = respostaCorreta;
        this.respostaSelecionada = respostaSelecionada;
        this.correta = correta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuizResultado getQuizResultado() {
        return quizResultado;
    }

    public void setQuizResultado(QuizResultado quizResultado) {
        this.quizResultado = quizResultado;
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    public String getRespostaSelecionada() {
        return respostaSelecionada;
    }

    public void setRespostaSelecionada(String respostaSelecionada) {
        this.respostaSelecionada = respostaSelecionada;
    }

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }
}

package br.com.qniversity.api.models.dtos;

public class QuestaoResultadoDTO {

    private Long id;

    private String questao;

    private String respostaCorreta;

    private String respostaSelecionada;

    private boolean correta;

    public QuestaoResultadoDTO() {
    }

    public QuestaoResultadoDTO(Long id, String questao, String respostaCorreta, String respostaSelecionada, boolean correta) {
        this.id = id;
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

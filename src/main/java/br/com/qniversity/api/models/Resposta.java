package br.com.qniversity.api.models;

import br.com.qniversity.api.models.dtos.RespostaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private boolean correta;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "questao_id", foreignKey = @ForeignKey(name = "fk_resposta_questao"))
    private Questao questao;

    public Resposta() {
    }

    public Resposta(String descricao, boolean correta) {
        this.descricao = descricao;
        this.correta = correta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public static RespostaDTO converter(Resposta resposta) {
        return new RespostaDTO(resposta.getDescricao(), resposta.isCorreta());
    }
}

package br.com.qniversity.api.models.dtos;

import br.com.qniversity.api.models.Quiz;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class QuizDTO {

    private String nome;
    private String descricao;
    private boolean ativo;
    private List<Long> questoesIds;

    public QuizDTO(String nome, String descricao, boolean ativo) {
        this.nome = nome;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    @NotEmpty(message = "O Quiz deve possuir um nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotEmpty(message = "O Quiz deve possuir uma descrição")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Long> getQuestoesIds() {
        return questoesIds;
    }

    public void setQuestoesIds(List<Long> questoesIds) {
        this.questoesIds = questoesIds;
    }

    public Quiz converter() {
        return new Quiz(this.nome, this.descricao, this.ativo);
    }
}

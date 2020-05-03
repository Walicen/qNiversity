package br.com.qniversity.api.models.dtos;

import br.com.qniversity.api.models.Curso;

import javax.validation.constraints.NotNull;


public class CursoDTO {


    private String nome;
    private int qtdPeriodos;

    public CursoDTO(String nome, int qtdPeriodos) {
        this.nome = nome;
        this.qtdPeriodos = qtdPeriodos;

    }


    @NotNull(message = "Nome do curso é obrigatório!")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotNull(message = "Quantidade de Períodos do curso é obrigatório!")
    public int getQtdPeriodos() {
        return qtdPeriodos;
    }

    public void setQtdPeriodos(int qtdPeriodos) {
        this.qtdPeriodos = qtdPeriodos;
    }

    public Curso converter() {
        return new Curso(this.nome, this.qtdPeriodos);
    }

}

package br.com.qniversity.api.models.dtos;

import br.com.qniversity.api.models.Curso;

import javax.validation.constraints.NotNull;


public class CursoDTO {

    private Long id;
    private String nome;
    private int qtdPeriodos;

    public CursoDTO(Long id, String nome, int qtdPeriodos) {
        this.id = id;
        this.nome = nome;
        this.qtdPeriodos = qtdPeriodos;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

package br.com.qniversity.api.models;

import br.com.qniversity.api.models.dtos.CursoDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome do curso é obrigatório!")
    private String nome;

    private int qtdPeriodos;


    public Curso() {
    }

    public Curso(String nome, int qtdPeriodos) {
        this.nome = nome;
        this.qtdPeriodos = qtdPeriodos;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdPeriodos() {
        return qtdPeriodos;
    }

    public void setQtdPeriodos(int qtdPeriodos) {
        this.qtdPeriodos = qtdPeriodos;
    }

    public CursoDTO converter() {
        return new CursoDTO(this.nome, this.qtdPeriodos);
    }


}

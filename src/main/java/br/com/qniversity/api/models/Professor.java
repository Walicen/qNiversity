package br.com.qniversity.api.models;

import br.com.qniversity.api.models.dtos.AlunoDTO;
import br.com.qniversity.api.models.dtos.ProfessorDTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;
    @NotNull
    private String sobrenome;

    @Email
    @NotNull
    private String email;

    @OneToOne()
    @JoinColumn(columnDefinition = "EMAIL")
    private Usuario usuario;

    public Professor() {
    }

    public Professor(String nome, String sobrenome, Usuario usuario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public ProfessorDTO converter() {
        return new ProfessorDTO(this.nome, this.sobrenome, this.email);
    }


}

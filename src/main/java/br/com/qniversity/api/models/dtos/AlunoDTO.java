package br.com.qniversity.api.models.dtos;

import br.com.qniversity.api.models.Aluno;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AlunoDTO {

    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String telefone;
    private Long turmaId;
    private boolean ranking;


    public AlunoDTO(String nome, String sobrenome, String email,  String telefone, boolean ranking) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
        this.ranking = ranking;
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

    @NotNull
    @NotEmpty(message = "E-mail não pode estar vazio.")
    @Email(message = "Digite um e-mail válido!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    @NotNull
    @NotEmpty(message = "Senha não pode estar vazio.")
    public String getSenha() {
        return senha;
    }

    @JsonProperty
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isRanking() {
        return ranking;
    }

    public void setRanking(boolean ranking) {
        this.ranking = ranking;
    }


    @NotNull(message = "Turma não pode estar vazio.")
    public Long getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
    }

    public Aluno converter() {
        return new Aluno(this.nome, this.sobrenome, this.email, this.telefone, this.ranking);
    }

}

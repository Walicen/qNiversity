package br.com.qniversity.api.models.dtos;

import br.com.qniversity.api.models.Aluno;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class AlunoDTO {

    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private boolean ranking;

    public AlunoDTO(String nome, String sobrenome, String email, String telefone, boolean ranking) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Aluno converter(){
        return new Aluno(this.nome, this.sobrenome, this.email, this.telefone, this.ranking);
    }

}

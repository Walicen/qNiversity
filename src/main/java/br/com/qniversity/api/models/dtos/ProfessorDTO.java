package br.com.qniversity.api.models.dtos;

import br.com.qniversity.api.models.Professor;
import br.com.qniversity.api.models.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class ProfessorDTO {

    private String nome;
    private String sobrenome;
    private String email;
    private String senha;

    public ProfessorDTO() {
    }

    public ProfessorDTO(String nome, String sobrenome, String email, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }

    public ProfessorDTO(String nome, String sobrenome, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
    }

    @NotEmpty(message = "Nome não pode ser vazio.")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotEmpty(message = "Sobrenome não pode ser vazio.")
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @NotEmpty(message = "Email não pode ser vazio.")
    @Length(min = 5, max = 200, message = "Email deve conter entre 5 e 200 caracteres.")
    @Email(message = "Email inválido.")
    public String getEmail() {
        return email;
    }

    @JsonIgnore
    @NotEmpty(message = "Senha não pode ser vazia.")
    @Length(min = 5, max = 200, message = "Senha deve conter entre 6 e 200 caracteres.")
    public String getSenha() {
        return senha;
    }

    @JsonProperty
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Professor converter() {
        final Usuario usuario = new Usuario(this.email, this.senha);
        return new Professor(this.nome, this.sobrenome, this.email, usuario);
    }
}


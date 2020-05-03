package br.com.qniversity.api.models.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class ProfessorDTO {


    private String nome;
    private String sobrenome;
    private String email;

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

    public void setEmail(String email) {
        this.email = email;
    }
}

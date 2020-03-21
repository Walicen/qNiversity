package br.com.qniversity.api.models.dtos;

import br.com.qniversity.api.models.User;
import br.com.qniversity.api.utils.PasswordUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String senha;
    private String email;
    private String cpf;
    private int profile; //1 Usuario - 2 ADMIN

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.nome = user.getFirstName();
        this.sobrenome = user.getLastName();
        this.senha = user.getPassword();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.profile = user.getProfile().ordinal();
    }

    public User converter() {
        return new User(this.id, this.nome, PasswordUtils.gerarBCrypt(this.senha), this.sobrenome,  this.email, this.cpf, this.profile);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotEmpty(message = "Nome não pode ser vazio.")
    @Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
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

    @NotEmpty(message = "Senha não pode ser vazia.")
    @Length(min = 6, max = 100, message = "Senha deve conter entre 6 e 100 caracteres.")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    @NotEmpty(message = "CPF não pode ser vazio.")
    @CPF(message = "CPF inválido")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

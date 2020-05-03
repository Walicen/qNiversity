package br.com.qniversity.api.models.dtos;

import br.com.qniversity.api.models.Usuario;
import br.com.qniversity.api.utils.PasswordUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserDTO {


    private String senha;
    private String email;
    private int profile; //1 Usuario - 2 ADMIN

    public UserDTO() {
    }

    public UserDTO(Usuario user) {

        this.senha = user.getPassword();
        this.email = user.getEmail();
        this.profile = user.getProfile().ordinal();
    }

    public Usuario converter() {
        return new Usuario(this.email, PasswordUtils.gerarBCrypt(this.senha));
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


}

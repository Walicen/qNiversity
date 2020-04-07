package br.com.qniversity.api.models;

import br.com.qniversity.api.models.enums.PerfilEnum;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Length(min = 6)
    private String password;
    private PerfilEnum profile;

    public Usuario() {
    }

    public Usuario(Long id, String email, String password, int profile) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.profile = PerfilEnum.ROLE_USUARIO;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public PerfilEnum getProfile() {
        return profile;
    }
}

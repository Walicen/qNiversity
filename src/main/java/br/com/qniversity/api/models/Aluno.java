package br.com.qniversity.api.models;

import br.com.qniversity.api.models.dtos.AlunoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String sobrenome;

    @NotNull(message = "Um e-mail deve ser informado!")
    @Email(message = "Email deve ser válido!")
    private String email;

    private String telefone;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "turma_id")
    private Turma turma;

    @OneToOne()
    @JoinColumn(columnDefinition = "EMAIL")
    private Usuario usuario;

    private boolean ranking = false;

    public Aluno() {
    }

    public Aluno(String nome, String sobrenome, String email, String telefone, boolean ranking) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
        this.ranking = ranking;
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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isRanking() {
        return ranking;
    }

    public void setRanking(boolean ranking) {
        this.ranking = ranking;
    }

    public AlunoDTO converter() {
        return new AlunoDTO(this.nome, this.sobrenome, this.email, this.telefone, this.ranking);
    }
}

package br.com.qniversity.api.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    private String nome;

    @ManyToOne()
    private Turno turno;

    @ManyToOne()
    private Curso curso;

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;

    public Turma() {
    }

    public Turma(String nome, String codigo, Turno turno, Curso curso, List<Aluno> alunos) {
        this.nome = nome;
        this.codigo = codigo;
        this.turno = turno;
        this.curso = curso;
        this.alunos = alunos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

}

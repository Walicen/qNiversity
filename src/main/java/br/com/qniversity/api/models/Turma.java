package br.com.qniversity.api.models;

import br.com.qniversity.api.models.dtos.TurmaDTO;

import javax.persistence.*;
import java.util.ArrayList;
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
    private List<Aluno> alunos = new ArrayList<>(0);


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "turma_quiz",
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "quiz_id"))
    private List<Quiz> quizzes = new ArrayList<>(0);

    public Turma() {
    }

    public Turma(String nome, String codigo, Turno turno, Curso curso) {
        this.nome = nome;
        this.codigo = codigo;
        this.turno = turno;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public TurmaDTO converter() {
        return new TurmaDTO(this.id, this.nome, this.curso.getId(), this.turno.getId());
    }
}

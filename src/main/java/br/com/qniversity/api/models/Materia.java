package br.com.qniversity.api.models;

import org.springframework.security.core.parameters.P;

import java.util.List;

public class Materia extends Curso {

    private String nome;
    private List<Curso> cursos;
    private Professor professor;

    public Materia() {
    }

    public Materia(String nome, List<Curso> cursos, Professor professor) {
        this.nome = nome;
        this.cursos = cursos;
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}

package br.com.qniversity.api.models;

import br.com.qniversity.api.models.enums.Nivel;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Nivel nivel;

    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resposta> respostas;

    @ManyToMany(mappedBy = "questoes")
    private Set<Quiz> quizList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public Set<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(Set<Quiz> quizList) {
        this.quizList = quizList;
    }
}

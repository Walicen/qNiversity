package br.com.qniversity.api.models;

import br.com.qniversity.api.models.dtos.QuestaoDTO;
import br.com.qniversity.api.models.dtos.RespostaDTO;
import br.com.qniversity.api.models.enums.Nivel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Nivel nivel;

    @OneToMany(mappedBy = "questao", cascade = {CascadeType.ALL, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Resposta> respostas = new ArrayList<>(0);

    @JsonIgnore
    @ManyToMany(mappedBy = "questoes", fetch = FetchType.LAZY)
    private Set<Quiz> quizList = new HashSet<>(0);

    public Questao() {
    }

    public Questao(String descricao, Nivel nivel, List<Resposta> respostas) {
        this.descricao = descricao;
        this.nivel = nivel;
        this.respostas = respostas;
    }

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

    public static QuestaoDTO converter(Questao questao) {
        final List<RespostaDTO> respostaDTOS = questao.getRespostas().stream().map(Resposta::converter).collect(Collectors.toList());
        return new QuestaoDTO(questao.getDescricao(), questao.getNivel(), respostaDTOS);
    }
}

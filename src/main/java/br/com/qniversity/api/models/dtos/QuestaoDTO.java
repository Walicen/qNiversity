package br.com.qniversity.api.models.dtos;

import br.com.qniversity.api.models.Questao;
import br.com.qniversity.api.models.Resposta;
import br.com.qniversity.api.models.enums.Nivel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public class QuestaoDTO {

    private Long id;
    private String descricao;
    private Nivel nivel;
    private List<RespostaDTO> respostas;

    public QuestaoDTO() {
    }

    public QuestaoDTO(String descricao, Nivel nivel) {
        this.descricao = descricao;
        this.nivel = nivel;
    }

    public QuestaoDTO(Long id, String descricao, Nivel nivel, List<RespostaDTO> respostas) {
        this.id = id;
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

    @NotNull
    @NotEmpty(message = "A descrição da questão não pode ser vazia")
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


    @NotNull
    @NotEmpty
    public List<RespostaDTO> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostaDTO> respostas) {
        this.respostas = respostas;
    }

    public Questao converter() {
        final List<Resposta> respostaList = this.respostas.stream().map(RespostaDTO::converter).collect(Collectors.toList());
        return new Questao(this.descricao, this.nivel, respostaList);
    }
}

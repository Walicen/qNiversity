package br.com.qniversity.api.models.dtos;

import br.com.qniversity.api.models.Resposta;

public class RespostaDTO {

    private Long id;
    private String descricao;
    private boolean correta;

    public RespostaDTO(Long id, String descricao, boolean correta) {
        this.id = id;
        this.descricao = descricao;
        this.correta = correta;
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

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }

    public Resposta converter() {
        return new Resposta(this.descricao, this.correta);
    }
}

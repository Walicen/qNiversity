package br.com.qniversity.api.models.dtos;

import br.com.qniversity.api.models.Resposta;

public class RespostaDTO {

    private String descricao;
    private boolean correta;

    public RespostaDTO(String descricao, boolean correta) {
        this.descricao = descricao;
        this.correta = correta;
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

    public Resposta converter(){
        return new Resposta(this.descricao, this.correta);
    }
}

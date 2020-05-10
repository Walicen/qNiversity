package br.com.qniversity.api.models.dtos;

import java.sql.Time;

public class TurnoDTO {

    private Long id;
    private String descricao;
    private Time inicio;
    private Time fim;


    public TurnoDTO(Long id, String descricao, Time inicio, Time fim) {
        this.id = id;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
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

    public Time getInicio() {
        return inicio;
    }

    public void setInicio(Time inicio) {
        this.inicio = inicio;
    }

    public Time getFim() {
        return fim;
    }

    public void setFim(Time fim) {
        this.fim = fim;
    }
}

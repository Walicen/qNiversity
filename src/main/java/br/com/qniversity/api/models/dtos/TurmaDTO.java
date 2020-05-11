package br.com.qniversity.api.models.dtos;

import br.com.qniversity.api.models.Curso;
import br.com.qniversity.api.models.Turma;
import br.com.qniversity.api.models.Turno;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class TurmaDTO {

    private Long id;
//    private String codigo;
    private String nome;
    private Long cursoId;
    private Long turnoId;

    public TurmaDTO(Long id, String nome, Long cursoId, Long turnoId) {
        this.id = id;
//        this.codigo = codigo;
        this.nome = nome;
        this.cursoId = cursoId;
        this.turnoId = turnoId;
    }

    @JsonProperty
    public Long getId() {
        return id;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public Long getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(Long turnoId) {
        this.turnoId = turnoId;
    }

    public Turma converter(Turno turno, Curso curso) {
        String cod = UUID.randomUUID().toString().split("-")[0];
        return new Turma(this.nome, cod, turno, curso);
    }
}

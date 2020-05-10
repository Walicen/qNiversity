package br.com.qniversity.api.models.dtos;

import br.com.qniversity.api.models.Turma;

public class InvitationDTO {

    private Long id;
    private String nome;
    private TurnoDTO turno;
    private CursoDTO curso;

    public InvitationDTO(Long id, String nome, TurnoDTO turno, CursoDTO curso) {
        this.id = id;
        this.nome = nome;
        this.turno = turno;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TurnoDTO getTurno() {
        return turno;
    }

    public void setTurno(TurnoDTO turno) {
        this.turno = turno;
    }

    public CursoDTO getCurso() {
        return curso;
    }

    public void setCurso(CursoDTO curso) {
        this.curso = curso;
    }

    public static InvitationDTO converter(Turma turma) {
        return new InvitationDTO(turma.getId(), turma.getNome(), turma.getTurno().converter(), turma.getCurso().converter());
    }
}

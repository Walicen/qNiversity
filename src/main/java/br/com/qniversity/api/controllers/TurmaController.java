package br.com.qniversity.api.controllers;

import br.com.qniversity.api.models.Curso;
import br.com.qniversity.api.models.Turma;
import br.com.qniversity.api.models.Turno;
import br.com.qniversity.api.models.dtos.TurmaDTO;
import br.com.qniversity.api.response.Response;
import br.com.qniversity.api.services.CursoService;
import br.com.qniversity.api.services.TurmaService;
import br.com.qniversity.api.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private TurnoService turnoService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getTurmaById(@PathVariable Long id) {

        Response<Turma> response = new Response<>();

        Optional<Turma> turma = turmaService.findById(id);

        if (turma.isPresent()) {
            response.setData(turma.get());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody TurmaDTO turmaDTO, BindingResult result) {

        Response<TurmaDTO> response = new Response<>();
        validateData(turmaDTO, result);

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }
        final Optional<Turno> turno = this.turnoService.findById(turmaDTO.getTurnoId());
        final Optional<Curso> curso = this.cursoService.findById(turmaDTO.getCursoId());
        final Turma turma = turmaDTO.converter(turno.get(), curso.get());
        this.turmaService.save(turma);

        response.setData(turmaDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll() {

        Response<List<Turma>> response = new Response<>();
        final List<Turma> turmas = turmaService.findAll();

        response.setData(turmas);
        return ResponseEntity.ok(response);

    }

    private void validateData(TurmaDTO turmaDTO, BindingResult result) {

        if (!this.cursoService.findById(turmaDTO.getCursoId()).isPresent()) {
            result.addError(new ObjectError("Curso", "Curso não encontrado."));
        }

        this.turmaService.findByNome(turmaDTO.getNome())
                .ifPresent(turma -> result.addError(new ObjectError("Turma", "Nome de turma já existente.")));
    }
}

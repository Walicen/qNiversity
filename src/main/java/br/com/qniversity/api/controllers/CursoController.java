package br.com.qniversity.api.controllers;

import br.com.qniversity.api.models.Curso;
import br.com.qniversity.api.models.Turma;
import br.com.qniversity.api.models.dtos.CursoDTO;
import br.com.qniversity.api.models.dtos.TurmaDTO;
import br.com.qniversity.api.response.Response;
import br.com.qniversity.api.services.CursoService;
import br.com.qniversity.api.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody CursoDTO cursoDTO, BindingResult result) {
        Response<CursoDTO> response = new Response<>();
        validateData(cursoDTO, result);

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        Curso curso = cursoDTO.converter();
        cursoService.save(curso);

        response.setData(cursoDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/turmas")
    public ResponseEntity<?> getTurmasByCurso(@PathVariable("id") Long id) {

        Response<List<TurmaDTO>> response = new Response<>();
        final List<Turma> turmas = turmaService.findByCurso(id);
        final List<TurmaDTO> dtos = turmas.stream().map(Turma::converter).collect(Collectors.toList());

        response.setData(dtos);
        return ResponseEntity.ok(response);

    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        Response<List<CursoDTO>> response = new Response<>();
        List<CursoDTO> dtos = cursoService.findAll().stream().map(Curso::converter).collect(Collectors.toList());

        response.setData(dtos);
        return ResponseEntity.ok(response);
    }

    private void validateData(CursoDTO cursoDTO, BindingResult result) {

        this.cursoService.findByNome(cursoDTO.getNome())
                .ifPresent(user -> result.addError(new ObjectError("Curso", " já existente.")));
    }

}

package br.com.qniversity.api.controllers;

import br.com.qniversity.api.models.Turma;
import br.com.qniversity.api.response.Response;
import br.com.qniversity.api.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> getTurmaById(@PathVariable Long id, BindingResult result) {

        Response<Turma> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        Optional<Turma> turma = turmaService.findById(id);

        if (turma.isPresent()) {
            response.setData(turma.get());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll() {

        Response<List<Turma>> response = new Response<>();
        final List<Turma> turmas = turmaService.findAll();

        response.setData(turmas);
        return ResponseEntity.ok(response);

    }
}

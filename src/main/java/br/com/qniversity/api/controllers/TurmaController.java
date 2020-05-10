package br.com.qniversity.api.controllers;

import br.com.qniversity.api.models.Turma;
import br.com.qniversity.api.response.Response;
import br.com.qniversity.api.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

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

    @GetMapping
    public ResponseEntity<?> getAll() {

        Response<List<Turma>> response = new Response<>();
        final List<Turma> turmas = turmaService.findAll();

        response.setData(turmas);
        return ResponseEntity.ok(response);

    }
}

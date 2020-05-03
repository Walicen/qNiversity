package br.com.qniversity.api.controllers;

import br.com.qniversity.api.models.Turma;
import br.com.qniversity.api.response.Response;
import br.com.qniversity.api.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public ResponseEntity<?> getAll() {

        Response<List<Turma>> response = new Response<>();
        final List<Turma> turmas = turmaService.findAll();

        response.setData(turmas);
        return ResponseEntity.ok(response);

    }
}

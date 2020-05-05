package br.com.qniversity.api.controllers;

import br.com.qniversity.api.models.Questao;
import br.com.qniversity.api.models.Turma;
import br.com.qniversity.api.response.Response;
import br.com.qniversity.api.services.QuestaoService;
import br.com.qniversity.api.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/questoes")
public class QuestaoController {

    @Autowired
    private QuestaoService questaoService;

    @GetMapping
    public ResponseEntity<?> getAll() {

        Response<List<Questao>> response = new Response<>();
        final List<Questao> questoes = questaoService.findAll();

        response.setData(questoes);
        return ResponseEntity.ok(response);

    }
}

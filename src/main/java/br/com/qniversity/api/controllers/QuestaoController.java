package br.com.qniversity.api.controllers;

import br.com.qniversity.api.models.Questao;
import br.com.qniversity.api.models.Quiz;
import br.com.qniversity.api.models.Turma;
import br.com.qniversity.api.models.dtos.QuestaoDTO;
import br.com.qniversity.api.models.dtos.QuizDTO;
import br.com.qniversity.api.response.Response;
import br.com.qniversity.api.services.QuestaoService;
import br.com.qniversity.api.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/questoes")
public class QuestaoController {

    @Autowired
    private QuestaoService questaoService;

    @GetMapping
    public ResponseEntity<?> getAll() {

        Response<List<QuestaoDTO>> response = new Response<>();
        final List<QuestaoDTO> list = questaoService.findAll().stream().map(Questao::converter).collect(Collectors.toList());

        response.setData(list);
        return ResponseEntity.ok(response);

    }

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody QuestaoDTO questaoDTO, BindingResult result) {
        Response<QuestaoDTO> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        final Questao questao = questaoDTO.converter();
        this.questaoService.save(questao);


        response.setData(questaoDTO);
        return ResponseEntity.ok(response);
    }
}

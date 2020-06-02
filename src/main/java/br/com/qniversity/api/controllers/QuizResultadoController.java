package br.com.qniversity.api.controllers;

import br.com.qniversity.api.models.Aluno;
import br.com.qniversity.api.models.Questao;
import br.com.qniversity.api.models.Quiz;
import br.com.qniversity.api.models.QuizResultado;
import br.com.qniversity.api.models.dtos.QuizDTO;
import br.com.qniversity.api.models.dtos.QuizResultadoDTO;
import br.com.qniversity.api.response.Response;
import br.com.qniversity.api.services.QuestaoService;
import br.com.qniversity.api.services.QuizResultadoService;
import br.com.qniversity.api.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/quiz-results")
public class QuizResultadoController {

    @Autowired
    private QuizResultadoService quizResultadoService;

    @Autowired
    private QuestaoService questaoService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        Response<List<QuizResultado>> response = new Response<>();
        final List<QuizResultado> resultados = quizResultadoService.findAll();

        response.setData(resultados);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody QuizResultadoDTO quizResultadoDTO, BindingResult result) {
        Response<QuizResultadoDTO> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        final QuizResultado quizResultado = quizResultadoDTO.converter(new Aluno(), new Quiz());


        response.setData(quizResultadoDTO);
        return ResponseEntity.ok(response);
    }
}

package br.com.qniversity.api.controllers;

import br.com.qniversity.api.models.Questao;
import br.com.qniversity.api.models.Quiz;
import br.com.qniversity.api.models.dtos.QuizDTO;
import br.com.qniversity.api.response.Response;
import br.com.qniversity.api.services.QuestaoService;
import br.com.qniversity.api.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestaoService questaoService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        Response<List<Quiz>> response = new Response<>();
        final List<Quiz> quizzes = quizService.findAll();

        response.setData(quizzes);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody QuizDTO quizDTO, BindingResult result) {
        Response<QuizDTO> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        Quiz quiz = quizDTO.converter();
        if (quizDTO.getQuestoesIds() != null) {
            final Set<Questao> questaoSet = quizDTO.getQuestoesIds()
                    .stream().map((i) -> this.questaoService.findById(i).get()).collect(Collectors.toSet());
            quiz.setQuestoes(questaoSet);
        }
        this.quizService.save(quiz);

        response.setData(quizDTO);
        return ResponseEntity.ok(response);
    }
}

package br.com.qniversity.api.controllers;

import br.com.qniversity.api.models.Professor;
import br.com.qniversity.api.models.dtos.ProfessorDTO;
import br.com.qniversity.api.response.Response;
import br.com.qniversity.api.services.ProfessorService;
import br.com.qniversity.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/professor")
public class ProfessorRegistration {


    @Autowired
    private UserService userService;

    @Autowired
    private ProfessorService professorService;


    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody ProfessorDTO professorDTO, BindingResult result) throws NoSuchAlgorithmException {

        Response<ProfessorDTO> response = new Response<>();
        validateData(professorDTO, result);

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(professorDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        Response<List<ProfessorDTO>> response = new Response<>();
        List<ProfessorDTO> dtos = professorService.findAll().stream().map(Professor::converter).collect(Collectors.toList());

        response.setData(dtos);
        return ResponseEntity.ok(response);
    }


    private void validateData(ProfessorDTO professorDTO, BindingResult result) {
        this.professorService.findByEmail(professorDTO.getEmail())
                .ifPresent(user -> result.addError(new ObjectError("Professor", "Email já existente.")));
    }

}

package br.com.qniversity.api.controllers;

import br.com.qniversity.api.models.Aluno;
import br.com.qniversity.api.models.Usuario;
import br.com.qniversity.api.models.dtos.AlunoDTO;
import br.com.qniversity.api.models.dtos.UserDTO;
import br.com.qniversity.api.repositories.AlunoRepository;
import br.com.qniversity.api.response.Response;
import br.com.qniversity.api.services.AlunoService;
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
@RequestMapping("/api/alunos")
public class AlunoRegistration {


    @Autowired
    private UserService userService;

    @Autowired
    private AlunoService alunoService;


    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody AlunoDTO alunoDTO, BindingResult result) throws NoSuchAlgorithmException {

        Response<AlunoDTO> response = new Response<>();
        validateData(alunoDTO, result);

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        Aluno aluno = alunoDTO.converter();
        alunoService.save(aluno);

        response.setData(alunoDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {

        Response<List<AlunoDTO>> response = new Response<>();
        List<AlunoDTO> alunoDTOS = alunoService.findAll().stream().map(Aluno::converter).collect(Collectors.toList());

        response.setData(alunoDTOS);
        return ResponseEntity.ok(response);
    }


    private void validateData(AlunoDTO alunoDTO, BindingResult result) {

        this.alunoService.findByEmail(alunoDTO.getEmail())
                .ifPresent(user -> result.addError(new ObjectError("Aluno", "Email já existente.")));
    }

}
package br.com.qniversity.api.controllers;

import br.com.qniversity.api.models.User;
import br.com.qniversity.api.models.dtos.UserDTO;
import br.com.qniversity.api.response.Response;
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
@RequestMapping("/api/cadastrar-usuario")
public class UserRegistration {


    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody UserDTO userDTO, BindingResult result) throws NoSuchAlgorithmException {

        Response<UserDTO> response = new Response<>();
        validateData(userDTO, result);

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        User user = userDTO.converter();
        userService.save(user);

        response.setData(userDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<UserDTO> userDTOS = userService.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(userDTOS);
    }

    private void validateData(UserDTO userDTO, BindingResult result) {

        this.userService.findByCpf(userDTO.getCpf())
                .ifPresent(user -> result.addError(new ObjectError("usuário", "CPF já existente.")));

        this.userService.findByEmail(userDTO.getEmail())
                .ifPresent(user -> result.addError(new ObjectError("usuário", "Email já existente.")));
    }

}

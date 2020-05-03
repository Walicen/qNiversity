package br.com.qniversity.api.controllers;

import br.com.qniversity.api.models.Usuario;
import br.com.qniversity.api.models.dtos.UserDTO;
import br.com.qniversity.api.response.Response;
import br.com.qniversity.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

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

        Usuario user = userDTO.converter();
        userService.save(user);

        response.setData(userDTO);
        return ResponseEntity.ok(response);
    }


    private void validateData(UserDTO userDTO, BindingResult result) {

        this.userService.findByEmail(userDTO.getEmail())
                .ifPresent(user -> result.addError(new ObjectError("usuário", "Email já existente.")));
    }

}

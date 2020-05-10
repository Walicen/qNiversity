package br.com.qniversity.api.controllers;

import br.com.qniversity.api.models.Turma;
import br.com.qniversity.api.models.dtos.InvitationDTO;
import br.com.qniversity.api.response.Response;
import br.com.qniversity.api.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/api/invitation")
public class InvitationController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping("/{cod}")
    @ResponseBody
    public ResponseEntity<?> getInvite(@PathVariable String cod) {

        Response<InvitationDTO> response = new Response<>();
        validateData(cod, response);
        if (response.getErrors().size() > 0) {
            return ResponseEntity.notFound().build();
        }


        final Optional<Turma> turma = this.turmaService.findByCodigo(cod);

        if (turma.isPresent()) {
            final InvitationDTO invitationDTO = InvitationDTO.converter(turma.get());
            response.setData(invitationDTO);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().build();
    }

    private void validateData(String cod, Response response) {
        final Optional<Turma> turma = this.turmaService.findByCodigo(cod);
        if (!turma.isPresent()) {
            response.setErrors(Arrays.asList(new ObjectError("Código", "não encontrado!")));
        }
    }
}

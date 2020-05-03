package br.com.qniversity.api.controllers;

import br.com.qniversity.api.models.Turno;
import br.com.qniversity.api.response.Response;
import br.com.qniversity.api.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/turno")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @GetMapping
    public ResponseEntity<?> getAll() {

        Response<List<Turno>> response = new Response<>();
        final List<Turno> turnos = turnoService.findAll();

        response.setData(turnos);
        return ResponseEntity.ok(response);

    }
}

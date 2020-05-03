package br.com.qniversity.api.services.impl;

import br.com.qniversity.api.models.Turno;
import br.com.qniversity.api.repositories.TurnoRepository;
import br.com.qniversity.api.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoServiceImpl implements TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Override
    public List<Turno> findAll() {
        return this.turnoRepository.findAll();
    }

    @Override
    public void save(Turno turno) {
        this.turnoRepository.save(turno);
    }
}

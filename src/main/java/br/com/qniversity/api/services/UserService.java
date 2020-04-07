package br.com.qniversity.api.services;

import br.com.qniversity.api.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findAll();

    void save(Usuario user);
}

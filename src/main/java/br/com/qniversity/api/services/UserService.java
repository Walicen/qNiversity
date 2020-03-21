package br.com.qniversity.api.services;

import br.com.qniversity.api.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findByCpf(String cpf);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    void save(User user);
}

package br.com.qniversity.api.services.impl;

import br.com.qniversity.api.models.Usuario;
import br.com.qniversity.api.repositories.UserRepository;
import br.com.qniversity.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public Optional<Usuario> findByEmail(String email) {
        return Optional.ofNullable(this.userRepository.findByEmail(email));
    }

    @Override
    public List<Usuario> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void save(Usuario user) {
        this.userRepository.save(user);
    }
}

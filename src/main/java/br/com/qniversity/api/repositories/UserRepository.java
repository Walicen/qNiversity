package br.com.qniversity.api.repositories;

import br.com.qniversity.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByCpf(String cpf);
    public User findByEmail(String email);

}

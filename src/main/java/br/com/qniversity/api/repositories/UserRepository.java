package br.com.qniversity.api.repositories;

import br.com.qniversity.api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByEmail(String email);

}

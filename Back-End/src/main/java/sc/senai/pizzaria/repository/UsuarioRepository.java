package sc.senai.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sc.senai.pizzaria.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}

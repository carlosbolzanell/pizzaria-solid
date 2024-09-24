package sc.senai.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sc.senai.pizzaria.entity.Cliente;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByUsername(String name);
}

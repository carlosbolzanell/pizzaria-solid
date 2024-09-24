package sc.senai.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sc.senai.pizzaria.entity.Bebida;

public interface BebidaRepository extends JpaRepository<Bebida, Long> {
}

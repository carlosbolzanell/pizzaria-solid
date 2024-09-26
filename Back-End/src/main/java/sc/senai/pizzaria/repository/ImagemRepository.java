package sc.senai.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sc.senai.pizzaria.entity.Imagem;

import java.util.Optional;

public interface ImagemRepository extends JpaRepository<Imagem, Long> {
    Optional<Imagem> findByCaminho(String caminho);
}

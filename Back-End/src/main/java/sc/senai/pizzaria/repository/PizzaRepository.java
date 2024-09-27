package sc.senai.pizzaria.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.pizzaria.entity.Pizza;
import sc.senai.pizzaria.enuns.Tamanho;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    Page<Pizza> findAllByTamanho(Tamanho tamanho, Pageable pageable);
}

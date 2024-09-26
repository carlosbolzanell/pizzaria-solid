package sc.senai.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sc.senai.pizzaria.entity.ProdutoQuantidade;

public interface ProdutoQuantidadeRepository extends JpaRepository<ProdutoQuantidade, Long> {
}

package sc.senai.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sc.senai.pizzaria.entity.Carrinho;

public interface CarrinhoRepositoy extends JpaRepository<Carrinho, Long> {
}

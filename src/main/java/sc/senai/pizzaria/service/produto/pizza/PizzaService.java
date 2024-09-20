package sc.senai.pizzaria.service.produto.pizza;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sc.senai.pizzaria.controller.dto.pizza.PizzaRequestDTO;
import sc.senai.pizzaria.entity.Pizza;

@Service
public interface PizzaService {
    void criarPizza(PizzaRequestDTO dto);
    Page<Pizza> listarPizzas(Pageable pageable);
}

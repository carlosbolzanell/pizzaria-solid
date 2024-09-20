package sc.senai.pizzaria.service.produto.pizza;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sc.senai.pizzaria.controller.dto.pizza.PizzaRequestDTO;
import sc.senai.pizzaria.entity.Pizza;
import sc.senai.pizzaria.repository.PizzaRepository;

@Service
@AllArgsConstructor
public class PizzaServiceImpl implements PizzaService{

    private final PizzaRepository repository;

    @Override
    public void criarPizza(PizzaRequestDTO dto) {
        Pizza pizza = new Pizza(dto);
        repository.save(pizza);
    }

    @Override
    public Page<Pizza> listarPizzas(Pageable pageable) {
        return repository.findAll(pageable);
    }
}

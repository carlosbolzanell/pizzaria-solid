package sc.senai.pizzaria.service.produto.pizza;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sc.senai.pizzaria.controller.dto.pizza.PizzaRequestDTO;
import sc.senai.pizzaria.controller.dto.pizza.PizzaResponseDTO;
import sc.senai.pizzaria.entity.Pizza;

@Service
public interface PizzaService {
    void criarPizza(PizzaRequestDTO dto, MultipartFile imagem);
    Page<PizzaResponseDTO> listarPizzas(Pageable pageable);
}

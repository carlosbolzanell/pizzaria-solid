package sc.senai.pizzaria.service.produto.pizza;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sc.senai.pizzaria.controller.dto.pizza.PizzaRequestDTO;
import sc.senai.pizzaria.controller.dto.pizza.PizzaResponseDTO;
import sc.senai.pizzaria.entity.Imagem;
import sc.senai.pizzaria.entity.Pizza;
import sc.senai.pizzaria.repository.PizzaRepository;
import sc.senai.pizzaria.service.imagem.ImagemServiceImpl;

@Service
@AllArgsConstructor
public class PizzaServiceImpl implements PizzaService{

    private final PizzaRepository repository;
    private final ImagemServiceImpl imagemService;

    @Override
    public void criarPizza(PizzaRequestDTO dto, MultipartFile imagem) {
        Pizza pizza = new Pizza(dto);
        Imagem imagemPizza = imagemService.criarImagem(imagem);
        pizza.setImagem(imagemPizza);
        repository.save(pizza);
    }

    @Override
    public Page<PizzaResponseDTO> listarPizzas(Pageable pageable) {
        return repository.findAll(pageable).map(PizzaResponseDTO::new);
    }
}

package sc.senai.pizzaria.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sc.senai.pizzaria.controller.dto.pizza.PizzaRequestDTO;
import sc.senai.pizzaria.service.produto.pizza.PizzaService;
import sc.senai.pizzaria.service.produto.pizza.PizzaServiceImpl;

@RestController
@RequestMapping("/pizza")
@CrossOrigin("*")
@AllArgsConstructor
public class PizzaController {

    private final PizzaServiceImpl service;

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> criarPizza(@RequestPart PizzaRequestDTO dto,
                                        @RequestPart MultipartFile imagem){
        service.criarPizza(dto, imagem);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> listarPizzas(@PageableDefault Pageable pageable){
        return new ResponseEntity<>(service.listarPizzas(pageable), HttpStatus.OK);
    }

}

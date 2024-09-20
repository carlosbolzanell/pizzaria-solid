package sc.senai.pizzaria.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sc.senai.pizzaria.controller.dto.pizza.PizzaRequestDTO;
import sc.senai.pizzaria.service.produto.pizza.PizzaService;
import sc.senai.pizzaria.service.produto.pizza.PizzaServiceImpl;

@RestController
@RequestMapping("/pizza")
@CrossOrigin("*")
@AllArgsConstructor
public class PizzaController {

    private final PizzaServiceImpl service;

    @PostMapping
    public ResponseEntity<?> criarPizza(@RequestBody PizzaRequestDTO dto){
        service.criarPizza(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('BASIC')")
    @GetMapping
    public ResponseEntity<?> listarPizzas(@PageableDefault Pageable pageable){
        return new ResponseEntity<>(service.listarPizzas(pageable), HttpStatus.OK);
    }

}

package sc.senai.pizzaria.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import sc.senai.pizzaria.service.carrinho.CarrinhoServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/carrinho")
@CrossOrigin("*")
public class CarrinhoController {

    private final CarrinhoServiceImpl service;

    @PostMapping("/adicionar")
    public ResponseEntity<?> adicionarProduto(@RequestParam Long idProduto, @RequestParam Integer quantidade,
                                           JwtAuthenticationToken token){
        service.adicionarProduto(idProduto, quantidade, token);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/adicionarQuantidade")
    public ResponseEntity<?> adicionarQuantidade(@RequestParam Long idProduto, JwtAuthenticationToken token){
        service.adicionarQuantidade(idProduto, token);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping("/removerQuantidade")
    public ResponseEntity<?> removerQuantidade(@RequestParam Long idProduto, JwtAuthenticationToken token){
        service.removerQuantidade(idProduto, token);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/remover")
    public ResponseEntity<?> removerProduto(@RequestParam Long idQuantidadeProduto, JwtAuthenticationToken token){
        service.removerProduto(idQuantidadeProduto, token);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/limpar")
    public ResponseEntity<?> limparCarrinho(JwtAuthenticationToken token){
        service.limparCarrinho(token);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

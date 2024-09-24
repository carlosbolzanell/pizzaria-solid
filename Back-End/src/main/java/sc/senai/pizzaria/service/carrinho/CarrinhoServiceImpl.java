package sc.senai.pizzaria.service.carrinho;

import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import sc.senai.pizzaria.entity.Carrinho;
import sc.senai.pizzaria.entity.Produto;
import sc.senai.pizzaria.entity.ProdutoQuantidade;
import sc.senai.pizzaria.repository.CarrinhoRepository;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CarrinhoServiceImpl implements CarrinhoService {

    private final CarrinhoRepository repository;

    @Override
    public void adicionarProduto(Long idProduto, Integer quantidade, JwtAuthenticationToken token) {
        ProdutoQuantidade produto = new ProdutoQuantidade(null, new Produto(idProduto), quantidade);
        Carrinho carrinho = buscarCarrinhoPorCliente(token.getName());
        carrinho.getProdutos().add(produto);
        System.out.println(carrinho.getProdutos().size());
        repository.save(carrinho);
    }

    @Override
    public void removerProduto(Long idQuantidadeProduto, JwtAuthenticationToken token) {

    }

    public Carrinho buscarCarrinhoPorCliente(String username){
        return repository.findByCliente_Username(username).orElseThrow(() ->
                new NoSuchElementException("Carrinho não encontrado"));
    }
}

package sc.senai.pizzaria.service.carrinho;

import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import sc.senai.pizzaria.entity.Carrinho;
import sc.senai.pizzaria.entity.Produto;
import sc.senai.pizzaria.entity.ProdutoQuantidade;
import sc.senai.pizzaria.repository.CarrinhoRepository;
import sc.senai.pizzaria.service.produtoQuantidade.ProdutoQuantidadeServiceImpl;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CarrinhoServiceImpl implements CarrinhoService {

    private final CarrinhoRepository repository;
    private final ProdutoQuantidadeServiceImpl produtoQuantidadeService;

    public void atualizarTotal(Carrinho carrinho){
        Double total = carrinho.getProdutos().stream()
                .mapToDouble(produto -> produto.getProduto().getPreco() * produto.getQuantidade())
                .sum();
        carrinho.setValorTotal(total);
    }

    @Override
    public void adicionarProduto(Long idProduto, Integer quantidade, JwtAuthenticationToken token) {
        ProdutoQuantidade produto = new ProdutoQuantidade(null, new Produto(idProduto), quantidade);
        Carrinho carrinho = buscarCarrinhoPorCliente(token.getName());
        carrinho.getProdutos().add(produto);
        carrinho = repository.save(carrinho);
        atualizarTotal(carrinho);
    }

    @Override
    public void removerProduto(Long idQuantidadeProduto, JwtAuthenticationToken token) {
        Carrinho carrinho = buscarCarrinhoPorCliente(token.getName());
        carrinho.getProdutos().removeIf(produto -> produto.getId().equals(idQuantidadeProduto));
        atualizarTotal(carrinho);
        repository.save(carrinho);
    }

    @Override
    public void adicionarQuantidade(Long idProduto, JwtAuthenticationToken token) {
        Carrinho carrinho = buscarCarrinhoPorCliente(token.getName());
        produtoQuantidadeService.adicionar(idProduto);
        atualizarTotal(carrinho);
        repository.save(carrinho);
    }

    @Override
    public void removerQuantidade(Long idProduto, JwtAuthenticationToken token){
        Carrinho carrinho = buscarCarrinhoPorCliente(token.getName());
        produtoQuantidadeService.remover(idProduto);
        atualizarTotal(carrinho);
        repository.save(carrinho);
    }

    public Carrinho buscarCarrinhoPorCliente(String username){
        return repository.findByCliente_Username(username).orElseThrow(() ->
                new NoSuchElementException("Carrinho não encontrado"));
    }

    public void limparCarrinho(JwtAuthenticationToken token) {
        Carrinho carrinho = buscarCarrinhoPorCliente(token.getName());
        carrinho.getProdutos().clear();
        atualizarTotal(carrinho);
        repository.save(carrinho);
    }
}

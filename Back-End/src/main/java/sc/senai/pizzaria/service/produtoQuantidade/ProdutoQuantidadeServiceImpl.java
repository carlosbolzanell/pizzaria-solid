package sc.senai.pizzaria.service.produtoQuantidade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.pizzaria.entity.ProdutoQuantidade;
import sc.senai.pizzaria.repository.ProdutoQuantidadeRepository;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ProdutoQuantidadeServiceImpl {

    private ProdutoQuantidadeRepository repository;

    public ProdutoQuantidade buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Produto não encontrado"));
    }

    public Integer adicionar(Long id){
        ProdutoQuantidade produtoQuantidade = buscarPorId(id);
        produtoQuantidade.setQuantidade(produtoQuantidade.getQuantidade() + 1);
        return repository.save(produtoQuantidade).getQuantidade();
    }

    public Integer remover(Long id){
        ProdutoQuantidade produtoQuantidade = buscarPorId(id);
        produtoQuantidade.setQuantidade(produtoQuantidade.getQuantidade() - 1);
        return repository.save(produtoQuantidade).getQuantidade();
    }
}

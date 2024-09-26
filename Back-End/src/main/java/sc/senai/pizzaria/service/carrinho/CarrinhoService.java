package sc.senai.pizzaria.service.carrinho;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public interface CarrinhoService {
    void adicionarProduto(Long idProduto, Integer quantidade, JwtAuthenticationToken token);
    void removerProduto(Long idQuantidadeProduto, JwtAuthenticationToken token);

    void adicionarQuantidade(Long idProduto, JwtAuthenticationToken token);
    void removerQuantidade(Long idProduto, JwtAuthenticationToken token);
}

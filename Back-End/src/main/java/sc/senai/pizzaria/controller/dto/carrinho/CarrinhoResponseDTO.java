package sc.senai.pizzaria.controller.dto.carrinho;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.pizzaria.entity.Carrinho;
import sc.senai.pizzaria.entity.ProdutoQuantidade;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CarrinhoResponseDTO {
    private Long id;
    private String nomeUsuario;
    private List<ProdutoQuantidadeResponseDTO> produtos;
    private Double valorTotal;

    public CarrinhoResponseDTO(Carrinho carrinho){
        this.id = carrinho.getId();
        this.nomeUsuario = carrinho.getCliente().getNome();
        this.produtos = carrinho.getProdutos().stream().map(ProdutoQuantidadeResponseDTO::new).toList();
        this.valorTotal = carrinho.getValorTotal();
    }
}

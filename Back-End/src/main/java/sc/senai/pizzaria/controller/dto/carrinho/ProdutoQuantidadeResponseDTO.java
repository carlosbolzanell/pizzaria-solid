package sc.senai.pizzaria.controller.dto.carrinho;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.pizzaria.controller.dto.produto.ProdutoResponseDTO;
import sc.senai.pizzaria.entity.ProdutoQuantidade;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoQuantidadeResponseDTO {
    private Long id;
    private ProdutoResponseDTO produto;
    private Integer quantidade;

    public ProdutoQuantidadeResponseDTO(ProdutoQuantidade produtoQuantidade) {
        this.id = produtoQuantidade.getId();
        this.produto = new ProdutoResponseDTO(produtoQuantidade.getProduto());
        this.quantidade = produtoQuantidade.getQuantidade();
    }
}

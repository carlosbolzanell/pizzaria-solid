package sc.senai.pizzaria.controller.dto.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.pizzaria.entity.Produto;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private String imagem;

    public ProdutoResponseDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.imagem = produto.getImagem().getCaminho();
    }
}

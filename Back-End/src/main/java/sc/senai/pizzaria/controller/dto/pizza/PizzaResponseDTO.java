package sc.senai.pizzaria.controller.dto.pizza;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.pizzaria.entity.Pizza;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PizzaResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private String imagem;
    private String tipo;
    private String tamanho;

    public PizzaResponseDTO(Pizza pizza) {
        this.id = pizza.getId();
        this.nome = pizza.getNome();
        this.descricao = pizza.getDescricao();
        this.preco = pizza.getPreco();
        this.imagem = pizza.getImagem().getCaminho();
        this.tipo = pizza.getTipo().getNome();
        this.tamanho = pizza.getTamanho().getNome();
    }

}

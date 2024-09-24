package sc.senai.pizzaria.controller.dto.pizza;

import sc.senai.pizzaria.enuns.Tipo;

public record PizzaRequestDTO(
        String nome,
        String descricao,
        double preco,
        Tipo tipo
) {
}

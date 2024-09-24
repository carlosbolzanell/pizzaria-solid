package sc.senai.pizzaria.controller.dto.bebida;

public record BebidaRequestDTO(
        String nome,
        String descricao,
        Double preco,
        Boolean gelada
) {
}

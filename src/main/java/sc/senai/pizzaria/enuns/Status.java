package sc.senai.pizzaria.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    PENDENTE("Aguardando confirmação"),
    EM_PREPARO("Em preparo"),
    PRONTO("Saiu para entrega"),
    ENTREGUE("Entregue"),
    CANCELADO("Cancelado");

    private final String nome;
}

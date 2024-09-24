package sc.senai.pizzaria.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MetodoPagamento {
    CARTAO("Cartão"),
    PIX("Pix"),
    DINHEIRO("Dinheiro");

    private final String nome;
}

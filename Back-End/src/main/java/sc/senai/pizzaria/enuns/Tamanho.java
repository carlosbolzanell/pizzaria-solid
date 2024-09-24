package sc.senai.pizzaria.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Tamanho {
    BROTO("Broto"),
    PEQUENA("Pequena"),
    MEDIA("Média"),
    GRANDE("Grande"),
    GIGANTE("Gigante");

    private final String nome;
}

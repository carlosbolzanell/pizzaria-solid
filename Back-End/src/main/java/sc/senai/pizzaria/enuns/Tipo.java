package sc.senai.pizzaria.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Tipo {
    SALGADA("Salgada"),
    DOCE("Doce");

    private final String nome;
}

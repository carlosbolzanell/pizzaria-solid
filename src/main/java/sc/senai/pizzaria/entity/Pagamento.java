package sc.senai.pizzaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.pizzaria.enuns.MetodoPagamento;
import sc.senai.pizzaria.enuns.Tipo;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private MetodoPagamento metodo;

    private Boolean pago = false;

}

package sc.senai.pizzaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sc.senai.pizzaria.controller.dto.pizza.PizzaRequestDTO;
import sc.senai.pizzaria.enuns.Tipo;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pizza extends Produto {

    @Column(nullable = false)
    private Tipo tipo;

    public Pizza (PizzaRequestDTO dto){
        super(dto);
        this.tipo = dto.tipo();
    }

}

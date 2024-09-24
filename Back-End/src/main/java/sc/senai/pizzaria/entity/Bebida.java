package sc.senai.pizzaria.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sc.senai.pizzaria.controller.dto.bebida.BebidaRequestDTO;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bebida extends Produto{
    private boolean gelada;

    public Bebida(BebidaRequestDTO dto){
        super(dto);
        this.gelada = dto.gelada();
    }
}

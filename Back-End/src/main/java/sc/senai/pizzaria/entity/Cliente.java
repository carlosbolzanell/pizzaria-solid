package sc.senai.pizzaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sc.senai.pizzaria.controller.dto.usuario.UsuarioRequestDTO;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente extends Usuario{

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false, name = "carrinho_id")
    private Carrinho carrinho;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToMany
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente (UsuarioRequestDTO usuarioDTO){
        super(usuarioDTO);
        this.carrinho = new Carrinho();
    }
}

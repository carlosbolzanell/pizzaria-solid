package sc.senai.pizzaria.controller.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.pizzaria.controller.dto.carrinho.CarrinhoResponseDTO;
import sc.senai.pizzaria.entity.Carrinho;
import sc.senai.pizzaria.entity.Cliente;
import sc.senai.pizzaria.entity.Usuario;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String usuario;
    private String email;
    private String autorizacao;
    private CarrinhoResponseDTO carrinho;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.usuario = usuario.getUsername();
        this.email = usuario.getEmail();
        this.autorizacao = usuario.getAutorizacao().name();
        if (usuario instanceof Cliente cliente) {
            this.carrinho = new CarrinhoResponseDTO(cliente.getCarrinho());
        }
    }
}

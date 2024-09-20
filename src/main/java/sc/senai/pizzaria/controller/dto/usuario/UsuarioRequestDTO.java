package sc.senai.pizzaria.controller.dto.usuario;

import sc.senai.pizzaria.enuns.Autorizacao;

public record UsuarioRequestDTO(
        String nome,
        String usuario,
        String email,
        String senha,
        Autorizacao autorizacao) {
}

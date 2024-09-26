package sc.senai.pizzaria.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import sc.senai.pizzaria.controller.dto.usuario.UsuarioRequestDTO;
import sc.senai.pizzaria.service.usuario.UsuarioService;

@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService usuarioService;

//    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public ResponseEntity<?> usuario(@RequestBody UsuarioRequestDTO usuarioDTO){
        return ResponseEntity.ok(usuarioService.criarUsuario(usuarioDTO));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public ResponseEntity<?> usuarioAutenticado(JwtAuthenticationToken token){
        return ResponseEntity.ok(usuarioService.buscarUsuario(token.getName()));
    }
}

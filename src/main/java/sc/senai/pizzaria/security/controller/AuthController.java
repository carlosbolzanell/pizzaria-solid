package sc.senai.pizzaria.security.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import sc.senai.pizzaria.controller.dto.usuario.UsuarioRequestDTO;
import sc.senai.pizzaria.security.controller.dto.LoginDTO;
import sc.senai.pizzaria.security.service.AuthService;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        try{
            return ResponseEntity.ok(service.verificarLogin(loginDTO.usuario(), loginDTO.senha()));
        }catch (BadCredentialsException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}

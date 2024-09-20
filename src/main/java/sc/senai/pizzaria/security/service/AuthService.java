package sc.senai.pizzaria.security.service;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sc.senai.pizzaria.entity.Usuario;
import sc.senai.pizzaria.repository.UsuarioRepository;
import sc.senai.pizzaria.security.controller.dto.LoginResponse;
import sc.senai.pizzaria.security.utils.JwtUtils;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {

    private UsuarioRepository repository;
    private PasswordEncoder passwordEncoder;
    private JwtUtils jwtUtils;

    public LoginResponse verificarLogin(String usuario, String senha){
        Optional<Usuario> usuario1 = repository.findByUsername(usuario);

        if(usuario1.isPresent()){
            if(passwordEncoder.matches(senha, usuario1.get().getPassword())){
                return jwtUtils.generateJwtToken(usuario1.get());
            }
        }
        throw new BadCredentialsException("Credenciais inválidas");
    }
}

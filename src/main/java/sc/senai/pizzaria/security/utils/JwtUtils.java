package sc.senai.pizzaria.security.utils;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;
import sc.senai.pizzaria.entity.Usuario;
import sc.senai.pizzaria.security.controller.dto.LoginResponse;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class JwtUtils {

    private final JwtEncoder jwtEncoder;

    public LoginResponse generateJwtToken(Usuario usuario) {
        Instant now = Instant.now();
        long expiresIn = 60L * 30L; //30 minutos
        String[] scopes = usuario.getAuthorities().stream().map(GrantedAuthority::getAuthority).toArray(String[]::new);

        JwtClaimsSet jwt = JwtClaimsSet.builder()
                .issuer("pizzaria")
                .subject(usuario.getUsername())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .claims(claims -> claims.put("authorities", scopes))
                .build();
        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(jwt)).getTokenValue();

        return new LoginResponse(jwtValue, expiresIn);
    }

}

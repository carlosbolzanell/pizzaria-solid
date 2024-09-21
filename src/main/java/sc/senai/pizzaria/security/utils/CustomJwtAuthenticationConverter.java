//package sc.senai.pizzaria.security.utils;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class CustomJwtAuthenticationConverter extends JwtAuthenticationConverter {
//
//    @Override
//    protected Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
//        // Pegar as authorities do claim "authorities"
//        List<String> authorities = jwt.getClaimAsStringList("authorities");
//
//        // Converter para SimpleGrantedAuthority para Spring Security
//        return authorities.stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//    }
//}
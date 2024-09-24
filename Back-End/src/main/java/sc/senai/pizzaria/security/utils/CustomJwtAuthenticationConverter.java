//package sc.senai.pizzaria.security.utils;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class CustomJwtAuthenticationConverter extends JwtAuthenticationConverter {
//
//    private final JwtGrantedAuthoritiesConverter defaultGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
//
//    protected Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
//        // Converter as autoridades padrão usando o JwtGrantedAuthoritiesConverter
//        Collection<GrantedAuthority> authorities = defaultGrantedAuthoritiesConverter.convert(jwt);
//
//        // Adicionar autoridades customizadas baseadas no claim "authorities"
//        List<String> customAuthorities = jwt.getClaimAsStringList("authorities");
//        if (customAuthorities != null) {
//            List<GrantedAuthority> customGrantedAuthorities = customAuthorities.stream()
//                    .map(SimpleGrantedAuthority::new)
//                    .collect(Collectors.toList());
//            authorities.addAll(customGrantedAuthorities);
//        }
//
//        return authorities;
//    }
//}

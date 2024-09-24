package sc.senai.pizzaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sc.senai.pizzaria.controller.dto.usuario.UsuarioRequestDTO;
import sc.senai.pizzaria.enuns.Autorizacao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Autorizacao autorizacao;
    private boolean desbloqueado = true;
    private boolean ativo = true;

    public Usuario(UsuarioRequestDTO usuarioDTO) {
        this.nome = usuarioDTO.nome();
        this.username = usuarioDTO.usuario();
        this.email = usuarioDTO.email();
        setPassword(usuarioDTO.senha());
        this.autorizacao = usuarioDTO.autorizacao();
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Autorizacao> autorizacoes = new ArrayList<>(List.of(this.autorizacao));
        if(this.autorizacao.equals(Autorizacao.ADMIN)){
            autorizacoes.add(Autorizacao.BASIC);
        }
        return autorizacoes;
    }
    @Override
    public boolean isAccountNonLocked() {
        return this.desbloqueado;
    }
    @Override
    public boolean isEnabled() {
        return this.ativo;
    }
}

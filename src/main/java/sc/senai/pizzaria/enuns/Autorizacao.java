package sc.senai.pizzaria.enuns;

import org.springframework.security.core.GrantedAuthority;

public enum Autorizacao implements GrantedAuthority {
    ADMIN, BASIC;


    @Override
    public String getAuthority() {
        return this.name();
    }
}

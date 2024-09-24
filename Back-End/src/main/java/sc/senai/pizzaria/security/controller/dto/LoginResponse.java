package sc.senai.pizzaria.security.controller.dto;

public record LoginResponse (String token, Long expiresIn) {
}

package sc.senai.pizzaria.service.usuario;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.pizzaria.controller.dto.usuario.UsuarioRequestDTO;
import sc.senai.pizzaria.controller.dto.usuario.UsuarioResponseDTO;
import sc.senai.pizzaria.entity.Cliente;
import sc.senai.pizzaria.repository.ClienteRepository;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UsuarioService {
    private ClienteRepository repository;

    public Cliente criarUsuario(UsuarioRequestDTO dto){
        Cliente cliente = new Cliente(dto);
        return repository.save(cliente);
    }

    public UsuarioResponseDTO buscarUsuario(String name) {
        Cliente cliente = repository.findByUsername(name).orElseThrow(NoSuchElementException::new);
        return new UsuarioResponseDTO(cliente);
    }
}

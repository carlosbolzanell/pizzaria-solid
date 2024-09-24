package sc.senai.pizzaria.service.produto.bebida;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.pizzaria.controller.dto.bebida.BebidaRequestDTO;
import sc.senai.pizzaria.entity.Bebida;
import sc.senai.pizzaria.repository.BebidaRepository;

@Service
@AllArgsConstructor
public class BebidaServiceImpl implements BebidaService {

    private final BebidaRepository repository;

    @Override
    public void cadastroBebida(BebidaRequestDTO dto) {
        Bebida bebida = new Bebida(dto);
        repository.save(bebida);
    }
}

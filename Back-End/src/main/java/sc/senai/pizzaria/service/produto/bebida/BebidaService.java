package sc.senai.pizzaria.service.produto.bebida;

import org.springframework.stereotype.Service;
import sc.senai.pizzaria.controller.dto.bebida.BebidaRequestDTO;

@Service
public interface BebidaService {

    void cadastroBebida(BebidaRequestDTO dto);

}

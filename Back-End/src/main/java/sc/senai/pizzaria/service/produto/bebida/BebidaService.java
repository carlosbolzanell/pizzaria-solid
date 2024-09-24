package sc.senai.pizzaria.service.produto.bebida;

import org.springframework.stereotype.Service;

@Service
public interface BebidaService {

    void cadastroBebida(BebidaDto bebidaDto);

}

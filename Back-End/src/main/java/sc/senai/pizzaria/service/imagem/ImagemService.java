package sc.senai.pizzaria.service.imagem;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sc.senai.pizzaria.entity.Imagem;

@Service
public interface ImagemService {

    Imagem criarImagem(MultipartFile file);

    void deletarImagem(Long id);

    void deletarImagem(String caminho);
}

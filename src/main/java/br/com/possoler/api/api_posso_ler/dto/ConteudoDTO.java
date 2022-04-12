package br.com.possoler.api.api_posso_ler.dto;

import br.com.possoler.api.api_posso_ler.entity.Conteudo;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ConteudoDTO {
    
    private Long qtdConteudo;

    public static ConteudoDTO parseToDTO(Conteudo conteudo)
    {
        return ConteudoDTO.builder()
            .qtdConteudo(conteudo.getQtdConteudo())
            .build();
    }
}

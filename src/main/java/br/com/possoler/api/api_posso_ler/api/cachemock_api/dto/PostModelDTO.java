package br.com.possoler.api.api_posso_ler.api.cachemock_api.dto;

import br.com.possoler.api.api_posso_ler.api.cachemock_api.model.PostModelEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostModelDTO {

    private String content;

    public static PostModelDTO parseToDTO(PostModelEntity postModelEntity)
    {
        return PostModelDTO.builder()
            .content(postModelEntity.getPageSource())
            .build();
    }
}

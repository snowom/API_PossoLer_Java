package br.com.possoler.api.api_posso_ler.cachemock_api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@Component
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetModelEntity {

    @NotEmpty(message = "O campo key não pode ser vazio")
    private String key;
}

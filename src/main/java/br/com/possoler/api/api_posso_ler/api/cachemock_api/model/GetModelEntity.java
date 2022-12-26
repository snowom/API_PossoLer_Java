package br.com.possoler.api.api_posso_ler.api.cachemock_api.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetModelEntity {

    @NotEmpty(message = "O campo key não pode ser vazio")
    private String key;
}

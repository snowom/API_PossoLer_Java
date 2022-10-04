package br.com.possoler.api.api_posso_ler.respondeai_api.dto;

import br.com.possoler.api.api_posso_ler.respondeai_api.entity.Variables;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
public class ExerciseRequestPayloadDTO {

    private String operationName;
    private String query;
    public Variables variables;
}

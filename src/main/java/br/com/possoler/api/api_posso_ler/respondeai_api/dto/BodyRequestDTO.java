package br.com.possoler.api.api_posso_ler.respondeai_api.dto;

import lombok.Getter;
import javax.validation.constraints.NotEmpty;

public class BodyRequestDTO {

    @Getter
    @NotEmpty(message = "O campo \"exerciseId\" não pode ser vazio")
    private String exerciseId;
}

package br.com.possoler.api.api_posso_ler.api.respondeai_api.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

public class ExerciseRequestDTO {

    @Getter
    @NotEmpty(message = "O campo \"exerciseId\" não pode ser vazio")
    private String exerciseId;
}

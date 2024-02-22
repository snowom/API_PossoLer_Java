package br.com.possoler.api.api_posso_ler.api.respondeai_api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

public class LessonRequestDTO {

    @Getter
    @NotEmpty(message = "O campo \"leassonId\" não pode ser vazio")
    @JsonProperty(value = "lesson_id", required = true)
    private String lessonId;
}

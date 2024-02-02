package br.com.possoler.api.api_posso_ler.api.respondeai_api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

public class LeassonRequestDTO {

    @Getter
    @NotEmpty(message = "O campo \"leassonId\" não pode ser vazio")
    @JsonProperty(value = "leasson_id", required = true)
    private String leassonId;
}

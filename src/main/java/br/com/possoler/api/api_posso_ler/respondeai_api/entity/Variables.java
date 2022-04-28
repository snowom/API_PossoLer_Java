package br.com.possoler.api.api_posso_ler.respondeai_api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Variables {

    private String id;
    private Boolean showBody;
}

package br.com.possoler.api.api_posso_ler.site.constants.global;

import lombok.Getter;

public enum InfoExtensao {
    VERSAO_EXTENSAO("298"),
    DATA_PUBLICACAO("22/02/2024");

    @Getter
    private String label;

    InfoExtensao(String label) {
        this.label = label;
    }
}

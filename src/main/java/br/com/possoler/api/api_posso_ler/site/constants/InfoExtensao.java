package br.com.possoler.api.api_posso_ler.site.constants;

import lombok.Getter;

public enum InfoExtensao {
    VERSAO_EXTENSAO("166"),
    DATA_PUBLICACAO("20/12/2022");

    @Getter
    private String label;

    InfoExtensao(String label) {
        this.label = label;
    }
}

package br.com.possoler.api.api_posso_ler.site.constants.i18n.en_us;

import lombok.Getter;

public enum en_VersaoExtensaoScriptEnum {

    LABEL_1(""),
    LABEL_2(""),
    LABEL_3(""),
    LABEL_4("");

    @Getter
    private String label;

    en_VersaoExtensaoScriptEnum(String label) {
        this.label = label;
    }
}

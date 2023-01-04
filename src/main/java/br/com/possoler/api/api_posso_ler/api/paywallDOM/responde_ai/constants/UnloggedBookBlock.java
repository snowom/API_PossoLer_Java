package br.com.possoler.api.api_posso_ler.api.paywallDOM.responde_ai.constants;

import lombok.Getter;

public enum UnloggedBookBlock {
    CLASS_1("ReactModalPortal"),
    CLASS_2("ReactModal__Body--open"),
    CLASS_3("NoAccessDisclaimer__Container-sc-6er3z1-0");

    @Getter
    private String className;

    UnloggedBookBlock(String className) {
        this.className = className;
    }
}

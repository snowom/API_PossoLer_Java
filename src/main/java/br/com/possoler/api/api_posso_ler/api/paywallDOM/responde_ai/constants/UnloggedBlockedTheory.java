package br.com.possoler.api.api_posso_ler.api.paywallDOM.responde_ai.constants;

import lombok.Getter;

public enum UnloggedBlockedTheory {
    CLASS_1("paywall"),
    CLASS_2("theory-container"),
    CLASS_3("expand-overlay");

    @Getter
    private String className;

    UnloggedBlockedTheory(String className) {
        this.className = className;
    }
}

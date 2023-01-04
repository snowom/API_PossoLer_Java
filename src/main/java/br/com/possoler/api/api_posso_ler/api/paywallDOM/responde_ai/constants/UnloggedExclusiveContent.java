package br.com.possoler.api.api_posso_ler.api.paywallDOM.responde_ai.constants;

import lombok.Getter;

public enum UnloggedExclusiveContent {
    CLASS_1("login-overlay"),
    CLASS_2("main-wrapper");

    @Getter
    private String className;

    UnloggedExclusiveContent(String className) {
        this.className = className;
    }
}

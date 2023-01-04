package br.com.possoler.api.api_posso_ler.api.paywallDOM.responde_ai.constants;

import lombok.Getter;

public enum UnloggedSolutionBlock {
    CLASS_1("exercise-expand-button"),
    CLASS_2("exercise-theory-expand-button"),
    CLASS_3("button");

    @Getter
    private String className;

    UnloggedSolutionBlock(String className) {
        this.className = className;
    }
}

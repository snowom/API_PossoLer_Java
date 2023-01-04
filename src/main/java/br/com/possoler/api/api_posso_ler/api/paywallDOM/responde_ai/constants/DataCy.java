package br.com.possoler.api.api_posso_ler.api.paywallDOM.responde_ai.constants;

import lombok.Getter;

public enum DataCy {
    FORMAT_TOGGLE("content-format-toggle-container"),
    THEORY_TEXT_CONTENT("theory-text-content-container"),
    THEORY_VIDEO_CONTENT("theory-video-content-container"),
    EXECISE_ANSWER_BUTTON("exercise-show-answer-button-container"),
    EXERCISE_STATEMENT("exercise-statement"),
    SIDE_MENU("side-menu-container");

    @Getter
    private String className;

    DataCy(String className) {
        this.className = className;
    }
}

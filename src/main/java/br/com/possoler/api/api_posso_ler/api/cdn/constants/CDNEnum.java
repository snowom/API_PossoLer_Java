package br.com.possoler.api.api_posso_ler.api.cdn.constants;

import lombok.Getter;

public enum CDNEnum {
    BLOCK_CORE_PAYWALL("blockCorePaywall", "[FF]blockCorePaywall.js"),
    SNACKBAR_JS("snackjs", "snackbar.js"),
    SNACKBAR_CSS("snackcss", "snackbar.css"),
    AXIOS_LOGO("axioslogo", "img/axiosJS.png"),
    MAVEN_LOGO("mavenlogo", "img/maven.png"),
    LOMBOK_LOGO("lomboklogo", "img/lombok.png"),
    SPRING_LOGO("springlogo", "img/spring.png"),
    POSSOLER_LOGO("possolerlogo", "img/128.png"),
    RESPONDE_AI_LOGO("respondeailogo", "img/respai.png"),
    GLIDE_JS("glidejs", "glide.min.js"),
    GLIDE_CORE_CSS("glidecorecss", "glide.core.min.css"),
    GLIDE_THEME_CSS("glidethemecss", "glide.theme.min.css"),
    EXTENSION_APP_RESPAI("app_respondeai", "extension/app_responde_ai/app_respondeai.js"),
    EXTENSION_RESPAI("respondeai", "extension/responde_ai/respondeai.js"),
    EXTENSION_VLR_ECON("valorecon", "extension/valor_economico/valor_economico.js"),
    EXTENSION_EXAME("exame", "extension/exame/exame.js"),
    EXTENSION_JOTA("jota", "extension/jota/jota.js"),
    EXTENSION_NYTIMES("nytimes", "extension/nytimes/nytimes.js"),
    EXTENSION_ELPAIS("elpais", "extension/elpais/elpais.js"),
    EXTENSION_GAUCHAZH("gauchazh", "extension/gauchazh/gauchazh.js"),
    EXTENSION_OPOPULAR("opopular", "extension/opopular/opopular.js"),
    EXTENSION_DIARIOSM("diariosm", "extension/diariosm/diariosm.js"),
    EXTENSION_OTEMPOMG("otempomg", "extension/otempomg/otempomg.js"),
    EXTENSION_JORNALDOCOMERCIO("jornaldocomercio", "extension/jornaldocomercio/jornaldocomercio.js"),
    EXTENSION_OPOVO("opovo", "extension/opovo/opovo.js");

    @Getter
    private final String fileParamName;
    @Getter
    private final String filename;

    CDNEnum(String fileParamName, String filename) {
        this.fileParamName = fileParamName;
        this.filename = filename;
    }
}

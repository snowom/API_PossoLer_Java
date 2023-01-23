package br.com.possoler.api.api_posso_ler.api.cdn.constants;

import lombok.Getter;

public enum CDNEnum {
    BLOCK_CORE_PAYWALL("blockCorePaywall", "[FF]blockCorePaywall.js"),
    SNACKBAR_JS("snackjs", "static\\CDN\\snackbar.js"),
    SNACKBAR_CSS("snackcss", "static\\CDN\\snackbar.css"),
    AXIOS_LOGO("axioslogo", "static\\CDN\\img\\axiosJS.png"),
    MAVEN_LOGO("mavenlogo", "static\\CDN\\img\\maven.png"),
    LOMBOK_LOGO("lomboklogo", "static\\CDN\\img\\lombok.png"),
    SPRING_LOGO("springlogo", "static\\CDN\\img\\spring.png"),
    POSSOLER_LOGO("possolerlogo", "static\\CDN\\img\\128.png");

    @Getter
    private final String fileParamName;
    @Getter
    private final String filename;

    CDNEnum(String fileParamName, String filename) {
        this.fileParamName = fileParamName;
        this.filename = filename;
    }
}

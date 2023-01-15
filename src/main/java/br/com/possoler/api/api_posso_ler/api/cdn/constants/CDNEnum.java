package br.com.possoler.api.api_posso_ler.api.cdn.constants;

import lombok.Getter;

public enum CDNEnum {
    BLOCK_CORE_PAYWALL("blockCorePaywall", "[FF]blockCorePaywall.js"),
    SNACKBAR_JS("snackjs", "snackbar.js"),
    SNACKBAR_CSS("snackcss", "snackbar.css");

    @Getter
    private String fileParamName;
    @Getter
    private String filename;

    CDNEnum(String fileParamName, String filename) {
        this.fileParamName = fileParamName;
        this.filename = filename;
    }
}

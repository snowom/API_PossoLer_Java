package br.com.possoler.api.api_posso_ler.site.constants.i18n.en_us;

import lombok.Getter;

public enum en_CardChangelogEnum {
    LABEL_1("Details"),
    LABEL_2("Extension Version: "),
    LABEL_3("Publication date: "),
    LABEL_4("Installed version: "),
    LABEL_5(" - Download the latest version <a id=\"linkInstalacao\" href=\"\">HERE</a>"),
    LABEL_6("What's new in this version?"),
    LABEL_7(
    "<li class=\"lead\">Added Você SA</li>" +
        "<li class=\"lead\">Bypass fixed in Estadão</li>"+
        "<li class=\"lead\">Bypass fixed in Gaucha ZH</li>" +
        "<li class=\"lead\">Bypass fixed in Responde Aí</li>" +
        "<li class=\"lead\">Responde Aí video classes fully unlocked</li>" +
        "<li class=\"lead\">Removal extension detection block in Responde Aí</li>"
    ),
    LABEL_8(
    "<li class=\"lead\">130KB decrease in Userscript size</li>" +
        "<li class=\"lead\">Changing architecture from extension software to microservices</li>" +
        "<li class=\"lead\">Performance improvements to the extension's backend system</li>" +
        "<li class=\"lead\">Fixed some bugs in previous versions</li>"
    ),
    LABEL_9("View full changelog");

    @Getter
    private String label;

    en_CardChangelogEnum(String label) {
        this.label = label;
    }
}

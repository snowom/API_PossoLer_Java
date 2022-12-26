package br.com.possoler.api.api_posso_ler.site.constants.i18n.en_us;

import lombok.Getter;

public enum en_BlocoTecnologiasEnum {

    LABEL_TECNOLOGIAS_USADAS("Used technologies"),
    LABEL_1("In case you were curious about how the extension is made or even want to program your own extension, here are the principal technologies used to bring the project to life!"),
    LABEL_2("Javascript"),
    LABEL_3("Used in almost 70% of the project, it is primarily responsible for making the necessary manipulations on the "),
    LABEL_4("DOM"),
    LABEL_5(" so that it is possible to view blocked content on websites."),
    LABEL_6("PHP"),
    LABEL_7("Used in the other 30% of the project, the "),
    LABEL_8(" is considered the heart of the project, where it is used to build the "),
    LABEL_9("APIs"),
    LABEL_10(" that perform vital functions of the extension and the site, such as counting downloads, checking and sending update notifications of the extension. With it are also made the APIs that unblock sites with "),
    LABEL_11("hard paywall"),
    LABEL_12(" or who need requests that cannot be made through the frontend, such as Valor Econômico, Jornal O Popular, and Responde Aí."),
    LABEL_13("Frameworks and Libraries"),
    LABEL_14("Composer"),
    LABEL_15("It is a dependency and library manager for PHP. A true maestro who governs his project!"),
    LABEL_16("Axios"),
    LABEL_17("Axios is a Promise based HTTP client for making requests."),
    LABEL_18("Guzzle"),
    LABEL_19("Guzzle is a simple PHP HTTP client that provides an easy way to create calls and integrate with web services."),
    LABEL_20("SweetAlert"),
    LABEL_21("SweetAlert is an API used to style and add functionality to dialog boxes in web applications.");

    @Getter
    private String label;

    en_BlocoTecnologiasEnum(String label) {
        this.label = label;
    }
}

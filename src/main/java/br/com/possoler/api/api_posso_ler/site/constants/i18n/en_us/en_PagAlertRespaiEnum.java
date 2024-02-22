package br.com.possoler.api.api_posso_ler.site.constants.i18n.en_us;

import lombok.Getter;

public enum en_PagAlertRespaiEnum {
    LABEL_1("DEV GOT CRAZY! TOTAL RETURN OF RESPONDE AÍ"),
    LABEL_2("Hey guys! After some time away, I'm back with good news! After \"giving Responde Aí some time off\", I decided to return to activities, and bring the website "),
    LABEL_3("fully unlocked "),
    LABEL_4("so that you can go back to studying without so many difficulties and do well in your subjects!"),
    LABEL_5("However, looking at the Responde Aí website, I saw that they implemented a Google advertising system. Therefore, as you are already accessing the content for free, I strongly ask that you DO NOT use ad blockers on this site, as they also need a source of income to support themselves, and between you and me, an ad in the corner of the screen doesn't hurt anyone, huh?"),
    LABEL_6("I thank everyone who wrote to me reporting the new website blocks and also contributing with palliative solutions while the project did not receive updates. Know that your help and interaction make "),
    LABEL_7("all the difference "),
    LABEL_8("in the project. I will try to focus more on project updates, but nothing is guaranteed, as I am the only one who takes care of it, and I am very busy with studies, personal life, and thinking about new projects that make more sense for my professional growth. But I will do my best to keep the project alive and as updated as possible!");

    @Getter
    private String label;

    en_PagAlertRespaiEnum(String label) {
        this.label = label;
    }
}

package br.com.possoler.api.api_posso_ler.site.constants.i18n.en_us;

import lombok.Getter;

public enum en_InstrucoesDownloadMobileEnum {
    LABEL_1("I still don't have the extension installed on my phone or I need to update it:"),
    LABEL_2("Did you see the step by step and find it complicated? Relax, we have a video tutorial to help you with this!"),
    LABEL_3("Download the extension on your mobile by clicking "),
    LABEL_4("HERE"),
    LABEL_5("Copy the access key provided"),
    LABEL_6("Install the "),
    LABEL_7("Kiwi Browser - Fast & Quiet"),
    LABEL_8(". (Skip step if you already have it installed)"),
    LABEL_9("When opening the browser, in the upper right corner, tap the icon represented by “three dots” on your home screen and go to “Extensions”."),
    LABEL_10("In the upper right corner of the screen, click on the flag called "),
    LABEL_11("\"Developer Mode\""),
    LABEL_12(" so that it stays on."),
    LABEL_13("When enabling the flag, 4 buttons will appear: "),
    LABEL_14("\"+(from store)\""),
    LABEL_15("\"+(from .zip/.crx/.user.js)\""),
    LABEL_16("\"Pack extension\""),
    LABEL_17("\"Refresh\""),
    LABEL_18(". Click on the second button: "),
    LABEL_19(". If you are asked to choose an action, please select your "),
    LABEL_20("file manager"),
    LABEL_21("Navigate to where the extension was downloaded (usually in the Downloads folder) and click on the "),
    LABEL_22("PossoLer.crx"),
    LABEL_23("Next, you can see that the extension has already been added in the browser, but it is still "),
    LABEL_24("not enabled"),
    LABEL_25(". To enable it, just click on the flag located at the bottom of the extension card (located to the right of the remove button) so that it stays on."),
    LABEL_26("A popup will appear stating that the extension has been disabled because it requires more permissions. Click "),
    LABEL_27("OK"),
    LABEL_28("Next, go to the site you want to see the unlocked content."),
    LABEL_29("After entering the site, the extension will show a popup asking for the "),
    LABEL_30("access key"),
    LABEL_31(" to activate the extension."),
    LABEL_32("Paste the access key you copied when downloading the extension into the requested field and wait for the activation to complete."),
    LABEL_33("Voila!"),
    LABEL_34(" You've successfully installed the extension and are ready to start using it!"),
    LABEL_35("Observation: "),
    LABEL_36("This key will only be asked for the first time you install the extension. If the extension is uninstalled from the browser or if you clear the browser data, it will be necessary to generate a new access key");

    @Getter
    private String label;

    en_InstrucoesDownloadMobileEnum(String label) {
        this.label = label;
    }
}

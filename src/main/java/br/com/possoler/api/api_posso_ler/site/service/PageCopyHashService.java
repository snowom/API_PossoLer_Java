package br.com.possoler.api.api_posso_ler.site.service;

import br.com.possoler.api.api_posso_ler.site.constants.configs.ConstantsConfigs;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.en_us.en_PageCopyHashEnum;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.es.es_PageCopyHashEnum;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.pt_br.br_PageCopyHashEnum;
import br.com.possoler.api.api_posso_ler.site.interfaces.FactoryHTMLElements;
import br.com.possoler.api.api_posso_ler.site.utils.LanguageUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class PageCopyHashService implements FactoryHTMLElements {

    private final LanguageUtils languageUtils;

    PageCopyHashService(LanguageUtils languageUtils) {
        this.languageUtils = languageUtils;
    }

    @Override
    public void factoryElement(String idioma, Model model) {
        idioma = languageUtils.preventNullLanguage(idioma);

        if(idioma.equalsIgnoreCase(ConstantsConfigs.LANG_EN.getIdioma())) {
            model.addAttribute("pagCopyHash_label1", en_PageCopyHashEnum.LABEL_1.getLabel());
            model.addAttribute("pagCopyHash_label2", en_PageCopyHashEnum.LABEL_2.getLabel());
            return;
        }
        if(idioma.equalsIgnoreCase(ConstantsConfigs.LANG_ES.getIdioma())) {
            model.addAttribute("pagCopyHash_label1", es_PageCopyHashEnum.LABEL_1.getLabel());
            model.addAttribute("pagCopyHash_label2", es_PageCopyHashEnum.LABEL_2.getLabel());
            return;
        }
        model.addAttribute("pagCopyHash_label1", br_PageCopyHashEnum.LABEL_1.getLabel());
        model.addAttribute("pagCopyHash_label2", br_PageCopyHashEnum.LABEL_2.getLabel());
    }

    public void setUserKey(Model model, String hash) {
        String userKey = this.returnValidHash(hash);
        model.addAttribute("pagCopyHash_userKey", userKey);
    }

    private String returnValidHash(String hash) {
        return (hash != null && !hash.equals(""))
            ? hash
            : "ERRO AO PEGAR CHAVE";
    }
}

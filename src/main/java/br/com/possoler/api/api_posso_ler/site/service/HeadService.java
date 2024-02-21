package br.com.possoler.api.api_posso_ler.site.service;

import br.com.possoler.api.api_posso_ler.site.constants.configs.ConstantsConfigs;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.en_us.en_HeadEnum;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.es.es_HeadEnum;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.pt_br.br_HeadEnum;
import br.com.possoler.api.api_posso_ler.site.model.Head;
import br.com.possoler.api.api_posso_ler.site.utils.LanguageUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class HeadService {

    private final LanguageUtils languageUtils;

    HeadService(LanguageUtils languageUtils) {
        this.languageUtils = languageUtils;
    }

    public void headFactory(String idioma, ModelAndView modelAndView) {

        idioma = languageUtils.preventNullLanguage(idioma);

        if(idioma.equalsIgnoreCase(ConstantsConfigs.LANG_EN.getIdioma())){
            modelAndView.addObject(
                "head",
                Head.builder()
                .headMessage(en_HeadEnum.LABEL_HEAD.getLabel())
                .build()
            );
            return;
        }
        if(idioma.equalsIgnoreCase(ConstantsConfigs.LANG_ES.getIdioma())){
            modelAndView.addObject(
    "head",
                Head.builder()
                .headMessage(es_HeadEnum.LABEL_HEAD.getLabel())
                .build()
            );
            return;
        }
        modelAndView.addObject(
            "head",
            Head.builder()
            .headMessage(br_HeadEnum.LABEL_HEAD.getLabel())
            .build()
        );
    }
}

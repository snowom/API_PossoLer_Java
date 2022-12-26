package br.com.possoler.api.api_posso_ler.site.service;

import br.com.possoler.api.api_posso_ler.site.constants.configs.ConstantsConfigs;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.en_us.en_HeadEnum;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.es.es_HeadEnum;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.pt_br.br_HeadEnum;
import br.com.possoler.api.api_posso_ler.site.model.Head;
import org.springframework.stereotype.Service;

@Service
public class HeadService {

    public Head headFactory(String idioma) {
        if(idioma.equalsIgnoreCase(ConstantsConfigs.LANG_EN.getIdioma())){
            return Head.builder().headMessage(en_HeadEnum.LABEL_HEAD.getLabel()).build();
        }
        if(idioma.equalsIgnoreCase(ConstantsConfigs.LANG_ES.getIdioma())){
            return Head.builder().headMessage(es_HeadEnum.LABEL_HEAD.getLabel()).build();
        }
        return Head.builder().headMessage(br_HeadEnum.LABEL_HEAD.getLabel()).build();
    }
}

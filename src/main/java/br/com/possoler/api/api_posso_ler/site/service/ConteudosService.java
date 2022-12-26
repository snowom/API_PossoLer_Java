package br.com.possoler.api.api_posso_ler.site.service;

import br.com.possoler.api.api_posso_ler.site.constants.configs.ConstantsConfigs;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.en_us.en_ConteudosEnum;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.es.es_ConteudosEnum;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.pt_br.br_ConteudosEnum;
import br.com.possoler.api.api_posso_ler.site.model.Conteudos;
import org.springframework.stereotype.Service;

@Service
public class ConteudosService {

    public Conteudos conteudoFactory(String idioma) {
        if(idioma.equalsIgnoreCase(ConstantsConfigs.LANG_EN.getIdioma())) {
            return Conteudos.builder()
                .labelQuantidadeConteudos(en_ConteudosEnum.LABEL_QUANTIDADE_CONTEUDOS.getLabel())
                .build();
        }
        if(idioma.equalsIgnoreCase(ConstantsConfigs.LANG_ES.getIdioma())) {
            return Conteudos.builder()
                .labelQuantidadeConteudos(es_ConteudosEnum.LABEL_QUANTIDADE_CONTEUDOS.getLabel())
                .build();
        }
        return Conteudos.builder()
            .labelQuantidadeConteudos(br_ConteudosEnum.LABEL_QUANTIDADE_CONTEUDOS.getLabel())
            .build();
    }
}

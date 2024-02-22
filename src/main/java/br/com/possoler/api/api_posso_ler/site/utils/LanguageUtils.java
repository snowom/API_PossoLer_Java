package br.com.possoler.api.api_posso_ler.site.utils;

import br.com.possoler.api.api_posso_ler.site.constants.configs.ConstantsConfigs;
import org.springframework.stereotype.Component;

@Component
public class LanguageUtils {

    /**
     * Se language for null, então essa funcao deve retornar o valor de um idioma padrão (PT-BR);
     * @param language
     * @return String
     */
    public String preventNullLanguage(String language) {
        return (language == null) ? ConstantsConfigs.LANG_BR.getIdioma() : language;
    }
}

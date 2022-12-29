package br.com.possoler.api.api_posso_ler.site.service;

import br.com.possoler.api.api_posso_ler.site.constants.InfoExtensao;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class VersaoExtensaoScriptService {

    public void versaoExtensaoScriptFactory(String idioma, Model model) {
        model.addAttribute("versaoExtensaoScript_versao", InfoExtensao.VERSAO_EXTENSAO.getLabel());
        model.addAttribute("versaoExtensaoScript_data", InfoExtensao.DATA_PUBLICACAO.getLabel());
    }
}

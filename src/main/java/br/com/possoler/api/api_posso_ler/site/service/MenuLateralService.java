package br.com.possoler.api.api_posso_ler.site.service;

import br.com.possoler.api.api_posso_ler.site.constants.configs.ConstantsConfigs;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.en_us.en_MenuLateralEnum;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.es.es_MenuLateralEnum;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.pt_br.br_MenuLateralEnum;
import br.com.possoler.api.api_posso_ler.site.model.MenuLateral;
import org.springframework.stereotype.Service;

@Service
public class MenuLateralService {

    public MenuLateral menuLateralFactory(String idioma) {
        if(idioma.equalsIgnoreCase(ConstantsConfigs.LANG_EN.getIdioma())){
            return MenuLateral.builder()
                    .MenuLateralMenu(en_MenuLateralEnum.MENU_LATERAL_MENU.getWord())
                    .MenuLateralInicio(en_MenuLateralEnum.MENU_LATERAL_INICIO.getWord())
                    .MenuLateralDownload(en_MenuLateralEnum.MENU_LATERAL_DOWNLOAD.getWord())
                    .MenuLateralSobre(en_MenuLateralEnum.MENU_LATERAL_SOBRE.getWord())
                    .MenuLateralApoiar(en_MenuLateralEnum.MENU_LATERAL_APOIAR.getWord())
                    .MenuLateralPerguntas(en_MenuLateralEnum.MENU_LATERAL_PERGUNTAS.getWord())
                    .MenuLateralTecnologias(en_MenuLateralEnum.MENU_LATERAL_TECNOLOGIAS.getWord())
                    .MenuLateralTutoriais(en_MenuLateralEnum.MENU_LATERAL_TUTORIAIS.getWord())
                    .MenuLateralComentarios(en_MenuLateralEnum.MENU_LATERAL_COMENTARIOS.getWord())
                    .MenuLateralVaiUmCafe(en_MenuLateralEnum.MENU_LATERAL_VAIUMCAFE.getWord())
                    .build();
        }
        if(idioma.equalsIgnoreCase(ConstantsConfigs.LANG_ES.getIdioma())){
            return MenuLateral.builder()
                    .MenuLateralMenu(es_MenuLateralEnum.MENU_LATERAL_MENU.getWord())
                    .MenuLateralInicio(es_MenuLateralEnum.MENU_LATERAL_INICIO.getWord())
                    .MenuLateralDownload(es_MenuLateralEnum.MENU_LATERAL_DOWNLOAD.getWord())
                    .MenuLateralSobre(es_MenuLateralEnum.MENU_LATERAL_SOBRE.getWord())
                    .MenuLateralApoiar(es_MenuLateralEnum.MENU_LATERAL_APOIAR.getWord())
                    .MenuLateralPerguntas(es_MenuLateralEnum.MENU_LATERAL_PERGUNTAS.getWord())
                    .MenuLateralTecnologias(es_MenuLateralEnum.MENU_LATERAL_TECNOLOGIAS.getWord())
                    .MenuLateralTutoriais(es_MenuLateralEnum.MENU_LATERAL_TUTORIAIS.getWord())
                    .MenuLateralComentarios(es_MenuLateralEnum.MENU_LATERAL_COMENTARIOS.getWord())
                    .MenuLateralVaiUmCafe(es_MenuLateralEnum.MENU_LATERAL_VAIUMCAFE.getWord())
                    .build();
        }
        return MenuLateral.builder()
                .MenuLateralMenu(br_MenuLateralEnum.MENU_LATERAL_MENU.getWord())
                .MenuLateralInicio(br_MenuLateralEnum.MENU_LATERAL_INICIO.getWord())
                .MenuLateralDownload(br_MenuLateralEnum.MENU_LATERAL_DOWNLOAD.getWord())
                .MenuLateralSobre(br_MenuLateralEnum.MENU_LATERAL_SOBRE.getWord())
                .MenuLateralApoiar(br_MenuLateralEnum.MENU_LATERAL_APOIAR.getWord())
                .MenuLateralPerguntas(br_MenuLateralEnum.MENU_LATERAL_PERGUNTAS.getWord())
                .MenuLateralTecnologias(br_MenuLateralEnum.MENU_LATERAL_TECNOLOGIAS.getWord())
                .MenuLateralTutoriais(br_MenuLateralEnum.MENU_LATERAL_TUTORIAIS.getWord())
                .MenuLateralComentarios(br_MenuLateralEnum.MENU_LATERAL_COMENTARIOS.getWord())
                .MenuLateralVaiUmCafe(br_MenuLateralEnum.MENU_LATERAL_VAIUMCAFE.getWord())
                .build();
    }
}

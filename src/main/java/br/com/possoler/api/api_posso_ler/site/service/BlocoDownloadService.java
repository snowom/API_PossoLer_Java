package br.com.possoler.api.api_posso_ler.site.service;

import br.com.possoler.api.api_posso_ler.site.constants.configs.ConstantsConfigs;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.en_us.en_BlocoDownloadEnum;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.es.es_BlocoDownloadEnum;
import br.com.possoler.api.api_posso_ler.site.constants.i18n.pt_br.br_BlocoDownloadEnum;
import br.com.possoler.api.api_posso_ler.site.model.BlocoDownload;
import org.springframework.stereotype.Service;

@Service
public class BlocoDownloadService {

    public BlocoDownload blocoDownloadFactory(String idioma) {
        if(idioma.equalsIgnoreCase(ConstantsConfigs.LANG_EN.getIdioma())) {
            return BlocoDownload.builder()
                .labelPessoasAcesso(en_BlocoDownloadEnum.LABEL_PESSOAS_ACESSO.getLabel())
                .labelDownload(en_BlocoDownloadEnum.LABEL_DOWNLOAD.getLabel())
                .labelPlataformaDownload(en_BlocoDownloadEnum.LABEL_PLATAFORMA_DOWNLOAD.getLabel())
                .labelOpcoes(en_BlocoDownloadEnum.LABEL_OPCOES.getLabel())
                .labelDesktopDownload(en_BlocoDownloadEnum.LABEL_DESKTOP_DOWNLOAD.getLabel())
                .labelMobileDownload(en_BlocoDownloadEnum.LABEL_MOBILE_DOWNLOAD.getLabel())
                .build();
        }
        if(idioma.equalsIgnoreCase(ConstantsConfigs.LANG_ES.getIdioma())) {
            return BlocoDownload.builder()
                .labelPessoasAcesso(es_BlocoDownloadEnum.LABEL_PESSOAS_ACESSO.getLabel())
                .labelDownload(es_BlocoDownloadEnum.LABEL_DOWNLOAD.getLabel())
                .labelPlataformaDownload(es_BlocoDownloadEnum.LABEL_PLATAFORMA_DOWNLOAD.getLabel())
                .labelOpcoes(es_BlocoDownloadEnum.LABEL_OPCOES.getLabel())
                .labelDesktopDownload(es_BlocoDownloadEnum.LABEL_DESKTOP_DOWNLOAD.getLabel())
                .labelMobileDownload(es_BlocoDownloadEnum.LABEL_MOBILE_DOWNLOAD.getLabel())
                .build();
        }
        return BlocoDownload.builder()
                .labelPessoasAcesso(br_BlocoDownloadEnum.LABEL_PESSOAS_ACESSO.getLabel())
                .labelDownload(br_BlocoDownloadEnum.LABEL_DOWNLOAD.getLabel())
                .labelPlataformaDownload(br_BlocoDownloadEnum.LABEL_PLATAFORMA_DOWNLOAD.getLabel())
                .labelOpcoes(br_BlocoDownloadEnum.LABEL_OPCOES.getLabel())
                .labelDesktopDownload(br_BlocoDownloadEnum.LABEL_DESKTOP_DOWNLOAD.getLabel())
                .labelMobileDownload(br_BlocoDownloadEnum.LABEL_MOBILE_DOWNLOAD.getLabel())
                .build();
    }
}

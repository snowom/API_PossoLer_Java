package br.com.possoler.api.api_posso_ler.site.constants.i18n.pt_br;

import lombok.Getter;

public enum br_CardChangelogEnum {
    LABEL_1("Detalhes"),
    LABEL_2("Versão da Extensão: "),
    LABEL_3("Data de publicação: "),
    LABEL_4("Versão instalada: "),
    LABEL_5(" - Baixe a versão mais recente <a id=\"linkInstalacao\" href=\"\">AQUI</a>"),
    LABEL_6("O que há de novo nessa versão?"),
    LABEL_7(
    "<li class=\"lead\">Adicionado Você SA</li>" +
        "<li class=\"lead\">Ajuste bypass Estadão</li>" +
        "<li class=\"lead\">Ajuste bypass Gaucha ZH</li>" +
        "<li class=\"lead\">Ajuste bypass Responde Aí</li>" +
        "<li class=\"lead\">Aulões Responde Aí totalmente desbloqueados</li>" +
        "<li class=\"lead\">Remoção bloqueio de detecção da extensão em Responde Aí</li>"

    ),
    LABEL_8(
        "<li class=\"lead\">Diminuição de 130KB no tamanho do Userscript</li>" +
        "<li class=\"lead\">Mudança de arquitetura de software da extensão para microserviços</li>" +
        "<li class=\"lead\">Melhorias de performance do sistema backend da extensão</li>" +
        "<li class=\"lead\">Correção de alguns bugs presentes nas versões anteriores</li>"
    ),
    LABEL_9("Ver changelog completo");

    @Getter
    private String label;

    br_CardChangelogEnum(String label) {
        this.label = label;
    }
}

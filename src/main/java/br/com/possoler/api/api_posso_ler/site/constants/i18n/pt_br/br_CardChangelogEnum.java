package br.com.possoler.api.api_posso_ler.site.constants.i18n.pt_br;

import lombok.Getter;

public enum br_CardChangelogEnum {
    LABEL_1("Detalhes"),
    LABEL_2("Versão da Extensão: "),
    LABEL_3("Data de publicação: "),
    LABEL_4("Versão instalada: "),
    LABEL_5("' - Baixe a versão mais recente <a id=\"linkInstalacao\" href=\"\">AQUI</a>"),
    LABEL_6("O que há de novo nessa versão?"),
    LABEL_7(
    "<li class=\"lead\">Adicionado Veja Saúde</li>" +
        "<li class=\"lead\">Adicionado Revista Casa e Jardim</li>" +
        "<li class=\"lead\">Ajuste Bypass Responde Aí</li>" +
        "<li class=\"lead\">Ajuste Bypass Exame</li>" +
        "<li class=\"lead\">Ajuste Bypass Globo Rural</li>" +
        "<li class=\"lead\">Ajuste Bypass Jornal do Comercio</li>"
    ),
    LABEL_8(
    "<li class=\"lead\">Criação de nova API para remoção de bloqueios do Responde Aí</li>" +
        "<li class=\"lead\">Melhorias de performance da extensão</li>" +
        "<li class=\"lead\">Correção de alguns bugs presentes nas versões anteriores</li>"
    ),
    LABEL_9("Ver changelog completo");

    @Getter
    private String label;

    br_CardChangelogEnum(String label) {
        this.label = label;
    }
}

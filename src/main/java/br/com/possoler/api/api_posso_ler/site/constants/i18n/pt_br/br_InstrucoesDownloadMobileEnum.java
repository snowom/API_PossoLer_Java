package br.com.possoler.api.api_posso_ler.site.constants.i18n.pt_br;

import lombok.Getter;

public enum br_InstrucoesDownloadMobileEnum {
    LABEL_1("Ainda não tenho a extensão instalada no meu celular ou preciso atualizá-la:"),
    LABEL_2("Viu o passo a passo e achou complicado? Relaxa que temos um video tutorial para te ajudar nessa!"),
    LABEL_3("Baixe a extensão em seu celular clicando "),
    LABEL_4("AQUI"),
    LABEL_5("Copie a chave de acesso disponibilizada"),
    LABEL_6("Instale o "),
    LABEL_7("Kiwi Browser - Fast & Quiet"),
    LABEL_8(". (Ignorar etapa caso já tenha ele instalado)"),
    LABEL_9("Ao abrir o navegador baixado, no canto superior direito, toque no ícone representado por “três pontos” em sua tela inicial e vá em “Extensões”."),
    LABEL_10("No canto superior direito da tela, clique na flag chamado "),
    LABEL_11("\"Modo do desenvolvedor\""),
    LABEL_12(" de forma que ela fique ligada."),
    LABEL_13("Ao habilitar a flag, aparecerão 4 botões: "),
    LABEL_14("\"+(from store)\""),
    LABEL_15("\"+(from .zip/.crx/.user.js)\""),
    LABEL_16("\"Compactar extensão\""),
    LABEL_17("\"Atualizar\""),
    LABEL_18(". Clique no segundo botão: "),
    LABEL_19(". Caso seja perguntado para escolher uma ação, selecione seu "),
    LABEL_20("gerenciador de arquivos"),
    LABEL_21("Navegue para onde a extensão foi baixada (geralmente na pasta Downloads) e clique no arquivo "),
    LABEL_22("PossoLer.crx"),
    LABEL_23("Em seguida, é possível ver que a extensão já foi adicionada no navegador, mas ela ainda "),
    LABEL_24("não foi habilitada"),
    LABEL_25(". Para habilitá-la, basta clicar na flag localizada no canto inferior do card da extensão (localizada ao canto direito do botão remover) de forma que ela fique ligada."),
    LABEL_26("Um popup aparecerá informando que a extensão foi desativada porque requer mais permissões. Clique em "),
    LABEL_27("OK"),
    LABEL_28("Em seguida, acesse o site que queira ver o conteúdo desbloqueado."),
    LABEL_29("Após entrar no site, a extensão mostrará um pop-up solicitando a "),
    LABEL_30("chave de acesso"),
    LABEL_31(" para ativar a extensão."),
    LABEL_32("Cole a chave de acesso que você copiou ao fazer o download da extensão no campo solicitado e espere a ativação ser concluída."),
    LABEL_33("Voila!"),
    LABEL_34("Você conseguiu instalar a extensão e já pode começar a usá-la!"),
    LABEL_35("Observação: "),
    LABEL_36("A chave de acesso só será solicitada na primeira vez que você executar a extensão. Caso a extensão seja desinstalada do navegador ou caso você limpe os dados do navegador, será necessário gerar uma nova chave de acesso.");

    @Getter
    private String label;

    br_InstrucoesDownloadMobileEnum(String label) {
        this.label = label;
    }
}

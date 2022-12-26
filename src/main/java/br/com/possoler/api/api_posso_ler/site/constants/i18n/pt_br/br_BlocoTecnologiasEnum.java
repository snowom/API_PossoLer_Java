package br.com.possoler.api.api_posso_ler.site.constants.i18n.pt_br;

import lombok.Getter;

public enum br_BlocoTecnologiasEnum {

    LABEL_TECNOLOGIAS_USADAS("Tecnologias usadas"),
    LABEL_1("Caso tenha ficado curioso de como a extensão é feita ou até mesmo queira programar sua própria extensão, aqui estão as principais tecnologias usadas para dar vida ao projeto!"),
    LABEL_2("Javascript"),
    LABEL_3("Usado em quase 70% do projeto, ele é o principal responsável por fazer as manipulações necessárias na "),
    LABEL_4("DOM"),
    LABEL_5(" para que seja possível a visualização dos conteúdos bloqueados nos sites."),
    LABEL_6("PHP"),
    LABEL_7("Usado nos outros 30% do projeto, o "),
    LABEL_8(" é considerado o coração do projeto, onde ele é utilizado para construir as "),
    LABEL_9("APIs "),
    LABEL_10("que realizam funções vitais da extensão e do site, como por exemplo, a contagem de downloads, verificação e envio de notificações de atualizações da extensão. Com ele também são feitas as APIs que desbloqueam sites com "),
    LABEL_11("hard paywall"),
    LABEL_12(" ou que precisam de solicitações que não podem ser feitas pelo frontend, como o Valor Econômico, Jornal O Popular, e o Responde Aí."),
    LABEL_13("Frameworks e bibliotecas"),
    LABEL_14("Composer"),
    LABEL_15("É um gerenciador de dependências e bibliotecas para PHP. Um verdadeiro maestro que rege seu projeto!"),
    LABEL_16("Axios"),
    LABEL_17("Axios é um cliente HTTP baseado em Promises para fazer requisições."),
    LABEL_18("Guzzle"),
    LABEL_19("Guzzle é um cliente PHP HTTP simples que fornece uma maneira fácil de criar chamadas e integração com serviços web."),
    LABEL_20("SweetAlert"),
    LABEL_21("O SweetAlert é uma API utilizada para estilizar e adicionar funcionalidades às caixas de diálogos em aplicações web.");

    @Getter
    private String label;

    br_BlocoTecnologiasEnum(String label) {
        this.label = label;
    }
}

package br.com.possoler.api.api_posso_ler.site.constants.i18n.pt_br;

import lombok.Getter;

public enum br_PagAlertRespaiEnum {
    LABEL_1("O DEV FICOU LOUCO! VOLTA TOTAL DO RESPONDE AÍ"),
    LABEL_2("Falaaa galera! Após algum tempo ausente, volto com boas novidades! Depois de \"dar um tempo de descanso ao Responde Aí\", decidi voltar as atividades, e  trago o site "),
    LABEL_3("totalmente desbloqueado "),
    LABEL_4("para que vocês possam voltar a estudar sem tantas dificuldades e mandarem bem nas matérias!"),
    LABEL_5("Contudo, olhando o site do Responde Aí, vi que eles implementaram um sistema de anúncios da Google. Portanto, como vocês já estão acessando o conteúdo gratuitamente, peço encarecidamente para que NÃO utilizem bloqueadores de anúncios nesse site, pois eles também necessitam de uma fonte de renda para se manter, e cá entre nós, um anúncio no cantinho da tela não machuca ninguém, né?"),
    LABEL_6("Agradeço a todos que me escreveram relatando os novos bloqueios do site, e que também contribuiram de alguma maneira com soluções paliativas enquanto o projeto não recebia atualizações. Saiba que a ajuda e a interação de vocês fazem "),
    LABEL_7("toda diferença "),
    LABEL_8("no projeto. Tentarei focar mais nas atualizações do projeto, porém nada garantido, pois sou apenas eu que cuido dele, e ando bem ocupado com estudos, vida pessoal, e pensando em novos projetos que fazem mais sentido para meu crescimento profissional, mas darei o máximo para manter o projeto vivo e o mais atualizado possível!");

    @Getter
    private String label;

    br_PagAlertRespaiEnum(String label) {
        this.label = label;
    }
}

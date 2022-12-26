package br.com.possoler.api.api_posso_ler.site.constants.i18n.es;

import lombok.Getter;

public enum es_BlocoTecnologiasEnum {

    LABEL_TECNOLOGIAS_USADAS("Tecnologías usadas"),
    LABEL_1("En caso de que tenga curiosidad acerca de cómo se hace la extensión o incluso quiera programar su propia extensión, ¡aquí están las tecnologías principales utilizadas para dar vida al proyecto!"),
    LABEL_2("Javascript"),
    LABEL_3("Utilizado en casi el 70% del proyecto, es el principal responsable de realizar las manipulaciones necesarias en el "),
    LABEL_4("DOM"),
    LABEL_5(" para que sea posible ver el contenido bloqueado en los sitios web."),
    LABEL_6("PHP"),
    LABEL_7("Usado en el otro 30% del proyecto, el "),
    LABEL_8(" se considera el corazón del proyecto, donde se utiliza para construir las "),
    LABEL_9("APIs"),
    LABEL_10(" que realizan funciones vitales de la extensión y el sitio, como contar descargas, verificar y enviar notificaciones de actualización de la extensión. Con él también se hacen las APIs que desbloquean sitios con "),
    LABEL_11("hard paywall"),
    LABEL_12(" o que necesitan solicitudes que no se pueden realizar a través del frontend, como Valor Econômico, Jornal O Popular y Responde Aí."),
    LABEL_13("Frameworks y bibliotecas"),
    LABEL_14("Composer"),
    LABEL_15("Es un administrador de bibliotecas y dependencias para PHP. ¡Un auténtico maestro que gobierna su proyecto!"),
    LABEL_16("Axios"),
    LABEL_17("Axios es un cliente HTTP basado en Promises para realizar solicitudes."),
    LABEL_18("Guzzle"),
    LABEL_19("Guzzle es un cliente PHP HTTP simple que proporciona una manera fácil de crear llamadas e integrarse con servicios web."),
    LABEL_20("SweetAlert"),
    LABEL_21("SweetAlert es una API que se utiliza para diseñar y agregar funcionalidad a los cuadros de diálogo en las aplicaciones web.");

    @Getter
    private String label;

    es_BlocoTecnologiasEnum(String label) {
        this.label = label;
    }
}

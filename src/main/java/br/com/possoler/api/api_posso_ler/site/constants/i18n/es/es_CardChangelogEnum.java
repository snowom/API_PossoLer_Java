package br.com.possoler.api.api_posso_ler.site.constants.i18n.es;

import lombok.Getter;

public enum es_CardChangelogEnum {
    LABEL_1("Detalles"),
    LABEL_2("Versión de extensión: "),
    LABEL_3("Fecha de publicación: "),
    LABEL_4("Versión instalada: "),
    LABEL_5("- Descargue la última versión <a id=\"linkInstalacao\" href=\"\"> AQUÍ </a>"),
    LABEL_6("¿Que hay de nuevo en esta versión?"),
    LABEL_7(
    "<li class=\"lead\">Se agregó soporte Você SA</li>"+
        "<li class=\"lead\">Corrección bypass en Estadão</li>" +
        "<li class=\"lead\">Corrección bypass en Gaucha ZH</li>" +
        "<li class=\"lead\">Corrección bypass en Responde Aí</li>" +
        "<li class=\"lead\">Videoclases de Responde Aí totalmente desbloqueadas</li>" +
        "<li class=\"lead\">Eliminación del bloqueo de detección de la extensión en Responde Aí</li>"
    ),
    LABEL_8(
    "<li class=\"lead\">Disminución de 130 KB en el tamaño de Userscript</li>" +
        "<li class=\"lead\">Fue cambiado la arquitectura de software de la extensión a microservicios</li>" +
        "<li class=\"lead\">Mejoras de rendimiento en el sistema backend de la extensión</li>" +
        "<li class=\"lead\">Se corrigieron algunos errores en versiones anteriores</li>"
    ),
    LABEL_9("Ver registro de cambios completo");

    @Getter
    private String label;

    es_CardChangelogEnum(String label) {
        this.label = label;
    }
}

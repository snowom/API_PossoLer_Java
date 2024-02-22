package br.com.possoler.api.api_posso_ler.site.constants.i18n.es;

import lombok.Getter;

public enum es_PagAlertRespaiEnum {
    LABEL_1("¡EL DESARROLLADOR SE VOLVIÓ LOCO! RENDIMIENTO TOTAL DE RESPONDE AÍ"),
    LABEL_2("¡Hola, chicos! ¡Después de un tiempo fuera, vuelvo con buenas noticias! Después de \"darle un tiempo libre a Responde Aí\", decidí volver a las actividades, y traer el sitio web "),
    LABEL_3("completamente desbloqueado "),
    LABEL_4("para que puedas volver a estudiar sin tantas dificultades y obtener buenos resultados en tus materias!"),
    LABEL_5("Sin embargo, mirando el sitio web de Responde Aí, vi que implementaron un sistema de publicidad de Google. Por lo tanto, como ya estás accediendo al contenido de forma gratuita, te pido encarecidamente que NO utilices bloqueadores de publicidad en este sitio, ya que ellos también necesitan una fuente de ingresos para mantenerse, y entre tú y yo, un anuncio en la esquina de La pantalla no hace daño a nadie, ¿eh?"),
    LABEL_6("Agradezco a todos los que me escribieron reportando los nuevos bloqueos del sitio web y también contribuyendo con soluciones paliativas mientras el proyecto no recibía actualizaciones. Sepa que su ayuda e interacción hacen "),
    LABEL_7("toda la diferencia "),
    LABEL_8("En el proyecto. Intentaré centrarme más en las actualizaciones del proyecto, pero nada está garantizado, ya que soy el único que me ocupa de ello y estoy muy ocupado con los estudios, la vida personal y pensando en nuevos proyectos que tengan más sentido para mi profesional. crecimiento. ¡Pero haré todo lo posible para mantener el proyecto vivo y lo más actualizado posible!");

    @Getter
    private String label;

    es_PagAlertRespaiEnum(String label) {
        this.label = label;
    }
}
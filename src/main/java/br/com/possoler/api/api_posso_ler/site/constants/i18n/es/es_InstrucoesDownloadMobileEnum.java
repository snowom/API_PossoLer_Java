package br.com.possoler.api.api_posso_ler.site.constants.i18n.es;

import lombok.Getter;

public enum es_InstrucoesDownloadMobileEnum {
    LABEL_1("Todavía no tengo la extensión instalada en mi teléfono o necesito actualizarla:"),
    LABEL_2("¿Viste el paso a paso y te resultó complicado? ¡Relájate, tenemos un video tutorial para ayudarte con esto! "),
    LABEL_3("Descarga la extensión en tu móvil haciendo clic en "),
    LABEL_4(" AQUÍ "),
    LABEL_5("Copie la clave de acceso proporcionada"),
    LABEL_6("Instale el "),
    LABEL_7(" Navegador Kiwi - Rápido y silencioso "),
    LABEL_8(". (Omita el paso si ya lo tiene instalado) "),
    LABEL_9("Al abrir el navegador, en la esquina superior derecha, toque el icono representado por \"tres puntos\" en su pantalla de inicio y vaya a \"Extensiones\"."),
    LABEL_10("En la esquina superior derecha de la pantalla, haga clic en la bandera llamada "),
    LABEL_11(" \"Modo de desarrollador\" "),
    LABEL_12(" para que permanezca encendida."),
    LABEL_13("Al habilitar la bandera, aparecerán 4 botones: "),
    LABEL_14("\"+(from store)\""),
    LABEL_15("\"+(from .zip/.crx/.user.js)\""),
    LABEL_16("\"Comprimir extensión\""),
    LABEL_17(" \"Actualizar\""),
    LABEL_18(". Haga clic en el segundo botón: "),
    LABEL_19(". Si se le pide que elija una acción, seleccione su "),
    LABEL_20("administrador de archivos "),
    LABEL_21("Navega hasta donde se descargó la extensión (normalmente en la carpeta Descargas) y haz clic en el archivo "),
    LABEL_22("PossoLer.crx"),
    LABEL_23("Luego puede ver que la extensión ya se agregó en el navegador, pero aún "),
    LABEL_24("no está habilitada "),
    LABEL_25(". Para habilitarla, simplemente haga clic en la bandera ubicada en la parte inferior de la tarjeta de extensión (ubicada a la derecha del botón Eliminar) para que permanezca encendida."),
    LABEL_26("Aparecerá una ventana emergente que indica que la extensión se ha deshabilitado porque requiere más permisos. Haga clic en "),
    LABEL_27("Aceptar"),
    LABEL_28("Luego, vaya al sitio donde desea ver el contenido desbloqueado."),
    LABEL_29("Después de ingresar al sitio, la extensión mostrará una ventana emergente solicitando la "),
    LABEL_30("clave de acceso"),
    LABEL_31(" para activar la extensión."),
    LABEL_32("Pegue la clave de acceso que copió al descargar la extensión en el campo solicitado y espere a que se complete la activación."),
    LABEL_33("¡Listo!"),
    LABEL_34(" ¡Has instalado correctamente la extensión y estás listo para comenzar a usarla!"),
    LABEL_35("Observación: "),
    LABEL_36("Esta clave solo se le pedirá la primera vez que instale la extensión. Si la extensión se desinstala del navegador o si borra los datos del navegador, será necesario generar una nueva clave de acceso.");

    @Getter
    private String label;

    es_InstrucoesDownloadMobileEnum(String label) {
        this.label = label;
    }
}

package com.unla.helpers;

public class ViewRouteHelper {

  //TEMPLATES: SON DIRECCIONES DENTRO DEL PROYECTO PARA MOSTRAR LA VISTA HTML
    public final static String INDEX = "/index";
    public final static String ROUTE = "/index";

    //USER
    public final static String USER_LOGIN = "user/login";
    public final static String USER_LOGOUT = "user/logout";

    //INDEX
    public final static String MEDICION_EST_FORM = "/index";

    //BAÑOS
    public final static String INDEX_BANIOS = "banios/index";
    public final static String NEW_BANIO = "banios/newBanio";
    public final static String BANIO_EVENTO = "banios/recordEvent";

    //ESTACIONAMIENTO
    public final static String REPORTES_ESTACIONAMIENTOS = "estacionamientos/getEstacionamientos";
    public final static String NEW_ESTACIONAMIENTO = "estacionamientos/newEstacionamiento";
    
    //MEDICIONES ESTACIONAMIENTO
    public final static String REPORTES_MEDICIONES = "mediciones/getMediciones";
    public final static String NEW_MEDICION = "mediciones/newMedicion";

    //ALUMBRADO
    public final static String REPORTES_ALUMBRADO = "alumbrado/getAlumbrado";//todas las aulas
    public final static String NEW_ALUMBRADO = "alumbrado/newAlumbrado"; //crear disp alumbrado
    public final static String REGISTRO_ALUMBRADO = "alumbrado/newAlumbradoMed"; //crear un evento
    public final static String REPORTES_ALUMBRADO_MED = "alumbrado/getAlumbradoMed"; // todas las mediciones alumbrado


    //REDIRECCIONES: ESTOS NO SON TEMPLATES SINO LOS URL DEL REDIRECTVIEW, QUE VUELVE A TOMAR EL CONTROLLER
    public final static String BANIO_ROOT = "/banios";
    public final static String ALUMBRADO_ROOT = "/alumbrado";
    public final static String ALUMBRADO_MEDICION_ROOT = "/medicion_alumbrado";
    

}

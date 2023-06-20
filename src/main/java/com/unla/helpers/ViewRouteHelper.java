package com.unla.helpers;

public class ViewRouteHelper {
    //EDIFICIO
    public final static String REPORTES_EDIFICIOS = "/getEdificios";

    //ESTACIONAMIENTO
    public final static String MEDICION_EST_FORM = "/login";

    //BAÑOS
    public final static String REPORTES_BANIOS = "banios/getBanios";
    public final static String NEW_BANIO = "banios/newBanio";
    public final static String REGISTRO_BANIO = "banios/recordEvent";

    //ESTACIONAMIENTO
    public final static String REPORTES_ESTACIONAMIENTOS = "estacionamientos/getEstacionamientos";
    public final static String NEW_ESTACIONAMIENTO = "estacionamientos/newEstacionamiento";
    
    //MEDICIONES ESTACIONAMIENTO
    public final static String REPORTES_MEDICIONES = "mediciones/getMediciones";
    public final static String NEW_MEDICION = "mediciones/newMedicion";

    //ALUMBRADO
    public final static String REPORTES_ALUMBRADO = "alumbrado/getAlumbrado";//todas las aulas
    public final static String REGISTRO_ALUMBRADO = "alumbrado/newAlumbradoMed"; //crear un evento 
    public final static String NEW_DISP_ALUMBRADO = "alumbrado/newAlumbrado"; //crear disp alumbrado
}

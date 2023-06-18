package com.unla.services;

import com.unla.entities.Banio;

public interface IMedicionBanioService {

    void cerrarPuerta(Banio banio) throws Exception;
    void liberarBanio(Banio banio)throws Exception;


}

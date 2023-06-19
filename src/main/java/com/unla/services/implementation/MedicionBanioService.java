package com.unla.services.implementation;

import com.unla.entities.Banio;
import com.unla.entities.Evento;
import com.unla.repositories.IDispositivoRepository;
import com.unla.services.IMedicionBanioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MedicionBanioService implements IMedicionBanioService {

    @Autowired
    @Qualifier("dispositivoRepository")
    private IDispositivoRepository repository;
    @Autowired
    @Qualifier("eventoService")
    private EventoService eventoService;


    @Override
    public void cerrarPuerta(Banio banio) throws Exception {
        //ubicar banio y chequear que este desocupado
        Banio banioAOcupar= repository.findBanioByIdDispositivo(banio.getIdDispositivo());
        if(banioAOcupar.isCerrojo()) throw new Exception("Este baño está ocupado actualmente. Espere a que se libere\n");
        //cambiar estado del cerrojo
        banioAOcupar.setCerrojo(true);
        //registrar evento de baño ocupado
        String descripcion= " El baño "+ banioAOcupar.getNumBanio() + " se acaba de ocupar. \n";
        Evento nuevoEvento= new Evento(LocalDateTime.now(),descripcion, true, banioAOcupar );
        eventoService.insertOrUpdate(nuevoEvento);
    }
    public void liberarBanio(Banio banio) throws Exception {
        //ubicar banio y chequear que este ocupado (esta excepcion no interrumpe la aplicacion)
        Banio banioALiberar= repository.findBanioByIdDispositivo(banio.getIdDispositivo());
        if(!banioALiberar.isCerrojo()) throw new Exception("Este baño ya está liberado\n");
        //cambiar estado del cerrojo
        banioALiberar.setCerrojo(false);
        //registrar evento de baño ocupado
        String descripcion= " El baño "+ banioALiberar.getNumBanio() + " se ha liberado. \n";
        Evento nuevoEvento= new Evento(LocalDateTime.now(),descripcion, true, banioALiberar );
        eventoService.insertOrUpdate(nuevoEvento);
    }
}

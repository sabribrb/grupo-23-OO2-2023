package com.unla.services.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.entities.Evento;
import com.unla.entities.MedicionEstacionamiento;
import com.unla.repositories.IMedicionEstacionamientoRepository;
import com.unla.services.IMedicionEstacionamientoService;


@Service
public class MedicionEstacionamientoService implements IMedicionEstacionamientoService {

	
	@Autowired
	@Qualifier("medicioEstacionamientoRepository")
	private IMedicionEstacionamientoRepository medicionEstacionamientoRepository;
	
	private EventoService eventoService;

	@Override
	public List<MedicionEstacionamiento> getAll() {
		return medicionEstacionamientoRepository.findAll();
	}

	@Override
	public MedicionEstacionamiento insertOrUpdate(MedicionEstacionamiento m) {
		MedicionEstacionamiento nuevaMedicion = medicionEstacionamientoRepository.save(m);
		return nuevaMedicion;
	}

	@Override
	public boolean remove(int id) {
		try {
			medicionEstacionamientoRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	
    @Override
    public void guardarMedicionEstacionamiento(MedicionEstacionamiento medicionEstacionamiento) {
        medicionEstacionamientoRepository.save(medicionEstacionamiento);

        // Verificar cambio de estado y crear el evento
        boolean cambioEstado = medicionEstacionamiento.isOcupado() != medicionEstacionamiento.isOcupado();
        
        if (cambioEstado==true) {
            Evento evento = new Evento(LocalDateTime.now(), "Lugar Libre", medicionEstacionamiento.isOcupado(), medicionEstacionamiento.getDispositivo());
            eventoService.insertOrUpdate(evento);
            // Lógica para guardar el evento en la base de datos
        }else { 
        	 Evento evento = new Evento(LocalDateTime.now(), "Lugar Ocupado", medicionEstacionamiento.isOcupado(), medicionEstacionamiento.getDispositivo());
        	 eventoService.insertOrUpdate(evento);
        }
    }
}

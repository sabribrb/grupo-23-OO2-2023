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

	@Autowired
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
	public void guardarMedicionEstacionamiento(MedicionEstacionamiento medicionEstacionamiento) {
		medicionEstacionamientoRepository.save(medicionEstacionamiento);
		
		boolean cambioEstado = medicionEstacionamiento.isOcupado();

		if (cambioEstado == false) {
			Evento evento = new Evento(LocalDateTime.now(),"El estacionamiento " + medicionEstacionamiento.getDispositivo().getNombre() + " Tiene el Lugar N°"+ medicionEstacionamiento.getNumeroLugar() + " Libre",
					medicionEstacionamiento.isOcupado(), medicionEstacionamiento.getDispositivo());
			eventoService.insertOrUpdate(evento);
			medicionEstacionamientoRepository.save(medicionEstacionamiento);
			
		} else {
			Evento evento = new Evento(LocalDateTime.now(),"El estacionamiento " + medicionEstacionamiento.getDispositivo().getNombre() + " Tiene el Lugar N°"+ medicionEstacionamiento.getNumeroLugar() + " Ocupado",
					medicionEstacionamiento.isOcupado(), medicionEstacionamiento.getDispositivo());
			eventoService.insertOrUpdate(evento);
			medicionEstacionamientoRepository.save(medicionEstacionamiento);
		}

	}

	@Override
	public List<MedicionEstacionamiento> getAllMedicionesEstacionamiento() {
		return medicionEstacionamientoRepository.getAllMedicionesEstacionamiento();
	}

}

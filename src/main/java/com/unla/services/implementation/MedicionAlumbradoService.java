package com.unla.services.implementation;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.entities.Evento;
import com.unla.entities.MedicionAlumbrado;
import com.unla.repositories.IMedicionAlumbradoRepository;
import com.unla.services.IMedicionAlumbradoService;

@Service
public class MedicionAlumbradoService implements IMedicionAlumbradoService {

	@Autowired
	@Qualifier("medicionAlumbradoRepository")
	private IMedicionAlumbradoRepository medicionAlumbradoRepository;
	
	private EventoService eventoService;

	@Override
	public List<MedicionAlumbrado> getAll() {
		return medicionAlumbradoRepository.findAll();
	}

	@Override
	public MedicionAlumbrado insertOrUpdate(MedicionAlumbrado m) {
		MedicionAlumbrado nuevaMedicion = medicionAlumbradoRepository.save(m);
		return nuevaMedicion;
	}

	@Override
	public boolean remove(int id) {
		try {
			medicionAlumbradoRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	
    @Override
    public void guardarMedicionAlumbrado(MedicionAlumbrado medicionAlumbrado) {
    	
        medicionAlumbradoRepository.save(medicionAlumbrado);
    
        //crear un evento de que el si hay gente el aula esta ocupada por lo cual se prenden las luces 
        //crear el evento prender luces si el aula esta ocupada o si son las 8 am 
        if (medicionAlumbrado.isHayGente()==true) {
            Evento evento = new Evento(LocalDateTime.now(), "Aula ocupada. Se prenden las luces", medicionAlumbrado.isHayGente(), medicionAlumbrado.getDispositivo());
            eventoService.insertOrUpdate(evento);
        
        }if(medicionAlumbrado.getHoraRegistro().equals(LocalTime.of(8, 00))) {
        	 Evento evento = new Evento(LocalDateTime.now(), "Se prenden las luces", medicionAlumbrado.isHayGente(), medicionAlumbrado.getDispositivo());
             eventoService.insertOrUpdate(evento);
        }
        else { 
        	 Evento evento = new Evento(LocalDateTime.now(), "Aula Libre", medicionAlumbrado.isHayGente(), medicionAlumbrado.getDispositivo());
        	 eventoService.insertOrUpdate(evento);
        }
    }

	@Override
	public List<MedicionAlumbrado> getAllMedicionesAlumbrado() {
		// TODO Auto-generated method stub
		return null;
	}
}

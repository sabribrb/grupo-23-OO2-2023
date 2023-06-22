package com.unla.services.implementation;

import java.util.ArrayList;
import java.util.List;

import com.unla.entities.Alumbrado;
import com.unla.entities.Banio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.entities.Dispositivo;
import com.unla.entities.Estacionamiento;
import com.unla.repositories.IDispositivoRepository;
import com.unla.services.IDispositivoService;

@Service
public class DispositivoService implements IDispositivoService {

	@Autowired
	@Qualifier("dispositivoRepository")
	private IDispositivoRepository dispositivoRepository;

	@Override
	public List<Dispositivo> getAll() {
		return dispositivoRepository.findAll();
	}

	@Override
	public Dispositivo insertOrUpdate(Dispositivo d) {
		Dispositivo dispositivoNuevo = dispositivoRepository.save(d);
		return dispositivoNuevo;
	}

	@Override
	public void removeDispositivo(int idDispositvo) {
			Dispositivo dispositivoNuevo = findByIdDispositivo(idDispositvo);
			dispositivoNuevo.setActivo(false);
			dispositivoRepository.save(dispositivoNuevo);
		
}

	@Override
	public List<Banio> getAllBanios() {
		return dispositivoRepository.getAllBanios();
	}

	@Override
	public Banio getBanioById(int id){
		return dispositivoRepository.findBanioByIdDispositivo(id);
	}
	@Override
	public List<Estacionamiento> getAllEstacionamiento() {
		List<Estacionamiento> lista = dispositivoRepository.getAllEstacionamiento();
		List<Estacionamiento> aux = new ArrayList<Estacionamiento>();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).isActivo() == true) {
				aux.add(lista.get(i));
			}

		}
		return aux;
	}
	
	public List<Alumbrado> getAllAlumbrado() {
		return dispositivoRepository.getAllAlumbrado();
	}

	@Override
	public Dispositivo findByIdDispositivo(int idDispositivo) {
		return dispositivoRepository.findByIdDispositivo(idDispositivo);
	}

}

package com.unla.services.implementation;

import java.util.ArrayList;
import java.util.List;

import com.unla.entities.Banio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.entities.Banio;
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
	public List<Dispositivo> getAll(){
		return dispositivoRepository.findAll();
	}

	@Override
	public Dispositivo findByIdDispositivo(int idDispositivo) {
		return dispositivoRepository.findByIdDispositivo(idDispositivo);
	}


	@Override
	public Dispositivo insertOrUpdate(Dispositivo d) {
		Dispositivo dispositivoNuevo = dispositivoRepository.save(d);
		return dispositivoNuevo;
	}

	@Override
	public boolean remove(int id) {
		try {
			Dispositivo dispositivoNuevo=findByIdDispositivo(id);
			dispositivoNuevo.setActivo(false);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Banio> getAllBanios() {
		return dispositivoRepository.getAllBanios();
	}

	@Override
	public List<Estacionamiento> getAllEstacionamiento() {
		List<Estacionamiento>lista=dispositivoRepository.getAllEstacionamiento();
		List<Estacionamiento>aux=new ArrayList<Estacionamiento>();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).isActivo()==false) {
				aux.add(lista.get(i));
			}
			
		}
		return aux;
	}

	/*@Override
	public Dispositivo findByNombreDispositivo(String nombre) {
		return dispositivoRepository.findByNombreDispositivo(nombre);
	}*/

	
}

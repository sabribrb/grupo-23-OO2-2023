package com.unla.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.entities.Dispositivo;
import com.unla.repositorys.IDispositivoRepository;
import com.unla.services.IDispositivoService;


@Service("dispositivoService")
public class DispositivoService implements IDispositivoService {

	@Autowired
	@Qualifier("dispositivoRepository")
	private IDispositivoRepository dispositivoRepository;

	@Override
	public List<Dispositivo> getAll(){
		return dispositivoRepository.findAll();
	}

	@Override
	public Dispositivo findById(int id) {
		return dispositivoRepository.findById(id);
	}

	@Override
	public Dispositivo findByName(String nombre) {
		return dispositivoRepository.findByName(nombre);
	}

	@Override
	public Dispositivo insertOrUpdate(Dispositivo d) {
		Dispositivo dispositivoNuevo = dispositivoRepository.save(d);
		return dispositivoNuevo;
	}

	@Override
	public boolean remove(int id) {
		try {
			dispositivoRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	
}

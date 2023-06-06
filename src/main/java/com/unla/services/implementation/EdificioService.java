package com.unla.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.entities.Edificio;
import com.unla.repositories.IEdificioRepository;
import com.unla.services.IEdificioService;

@Service
public class EdificioService implements IEdificioService{

	@Autowired
	@Qualifier("edificioRepository")
	private IEdificioRepository edificioRepository;

	@Override
	public List<Edificio> getAll() {
		return edificioRepository.findAll();
	}

	@Override
	public Edificio findByIdEdificio(int idEdificio) {
		return edificioRepository.findByIdEdificio(idEdificio);
	}

	/*@Override
	public Edificio findByName(String nombre) {
		return edificioRepository.findByName(nombre);
	}*/

	@Override
	public Edificio insertOrUpdate(Edificio d) {
		Edificio edificioNuevo = edificioRepository.save(d);
		return edificioNuevo;
	}

	@Override
	public boolean remove(int id) {
		try {
			edificioRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}

package com.unla.services;

import java.util.List;

import com.unla.entities.Banio;
import com.unla.entities.Dispositivo;
import org.springframework.web.bind.annotation.ModelAttribute;

public interface IDispositivoService {

	public List<Dispositivo> getAll();

	public Dispositivo findByIdDispositivo(int idDispositivo);

	//public Dispositivo findByNombreDispositivo(String nombre);

	public Dispositivo insertOrUpdate(Dispositivo d);

	public boolean remove(int id);
	@ModelAttribute("banios")
	public List<Banio> getAllBanios();
}

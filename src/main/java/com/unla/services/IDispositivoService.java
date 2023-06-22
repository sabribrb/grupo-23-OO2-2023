package com.unla.services;

import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.unla.entities.Alumbrado;
import com.unla.entities.Banio;
import com.unla.entities.Dispositivo;
import com.unla.entities.Estacionamiento;


public interface IDispositivoService {

	public List<Dispositivo> getAll();

	public Dispositivo findByIdDispositivo(int idDispositivo);

	public Dispositivo insertOrUpdate(Dispositivo d);

	public boolean remove(int id);
	
	@ModelAttribute("banios")
	public List<Banio> getAllBanios();

	public Banio getBanioById(int id);
	
	@ModelAttribute("estacionamiento")
	public List<Estacionamiento> getAllEstacionamiento();
	
	@ModelAttribute("alumbrado")
	public List<Alumbrado> getAllAlumbrado();
	
}

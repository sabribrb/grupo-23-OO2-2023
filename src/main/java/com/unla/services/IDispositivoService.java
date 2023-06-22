package com.unla.services;

import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.unla.entities.Banio;
import com.unla.entities.Dispositivo;
import com.unla.entities.Estacionamiento;


public interface IDispositivoService {

	public List<Dispositivo> getAll();

	public Dispositivo insertOrUpdate(Dispositivo d);

	public void removeDispositivo(int idDispositvo);
	
	@ModelAttribute("Dispositivo")
	public Dispositivo findByIdDispositivo(int idDispositivo);
	
	@ModelAttribute("banios")
	public List<Banio> getAllBanios();
	
	@ModelAttribute("estacionamiento")
	public List<Estacionamiento> getAllEstacionamiento();
}

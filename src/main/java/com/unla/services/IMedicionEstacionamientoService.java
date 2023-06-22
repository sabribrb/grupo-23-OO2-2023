package com.unla.services;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.unla.entities.MedicionEstacionamiento;

public interface IMedicionEstacionamientoService {

	public List<MedicionEstacionamiento> getAll();
	
	public MedicionEstacionamiento insertOrUpdate(MedicionEstacionamiento m);
	
	public void guardarMedicionEstacionamiento(MedicionEstacionamiento medicionEstacionamiento);
	
	@ModelAttribute("MedicionEstacionamiento")
	public List<MedicionEstacionamiento> getAllMedicionesEstacionamiento();
}

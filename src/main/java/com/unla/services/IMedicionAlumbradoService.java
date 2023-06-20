package com.unla.services;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.unla.entities.MedicionAlumbrado;

public interface IMedicionAlumbradoService {
	public List<MedicionAlumbrado> getAll();

	@ModelAttribute("medicion_alumbrado")
	public List<MedicionAlumbrado> getAllMedicionesAlumbrado();
	
	public MedicionAlumbrado insertOrUpdate(MedicionAlumbrado m);

	public boolean remove(int id);
	
	public void registrarMedicionAlumbrado(MedicionAlumbrado medicionAlumbrado);
	
	
}

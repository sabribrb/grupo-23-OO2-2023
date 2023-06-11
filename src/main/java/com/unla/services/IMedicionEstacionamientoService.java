package com.unla.services;

import java.util.List;

import com.unla.entities.MedicionEstacionamiento;

public interface IMedicionEstacionamientoService {

	public List<MedicionEstacionamiento> getAll();
	
	public MedicionEstacionamiento insertOrUpdate(MedicionEstacionamiento m);

	public boolean remove(int id);
	
	public void guardarMedicionEstacionamiento(MedicionEstacionamiento medicionEstacionamiento);
}

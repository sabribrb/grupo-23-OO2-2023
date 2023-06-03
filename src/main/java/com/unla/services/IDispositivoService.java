package com.unla.services;

import java.util.List;

import com.unla.entities.Dispositivo;

public interface IDispositivoService {

	public List<Dispositivo> getAll();

	public Dispositivo findById(int id);

	public Dispositivo findByName(String nombre);

	public Dispositivo insertOrUpdate(Dispositivo d);

	public boolean remove(int id);
}

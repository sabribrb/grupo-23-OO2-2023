package com.unla.services;

import java.util.List;

import com.unla.entities.Dispositivo;

public interface IDispositivoService {

	public List<Dispositivo> getAll();

	public Dispositivo findByIdDispositivo(int idDispositivo);

	public Dispositivo insertOrUpdate(Dispositivo d);

	public boolean remove(int id);
}

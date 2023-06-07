package com.unla.services;

import java.util.List;

import com.unla.entities.Evento;

public interface IEventoService {

	public List<Evento> getAll();

	public Evento findByIdEvento(int idEvento);

	public Evento insertOrUpdate(Evento e);

	public boolean remove(int id);
}

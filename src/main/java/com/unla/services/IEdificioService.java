package com.unla.services;

import java.util.List;

import com.unla.entities.Edificio;

public interface IEdificioService {

	public List<Edificio> getAll();

	public Edificio findByIdEdificio(int idEdificio);

	public Edificio insertOrUpdate(Edificio d);

	public boolean remove(int id);
}

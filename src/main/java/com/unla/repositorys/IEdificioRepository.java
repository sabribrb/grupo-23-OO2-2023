package com.unla.repositorys;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.entities.Edificio;

public interface IEdificioRepository extends JpaRepository<Edificio, Serializable>{


	public abstract Edificio findById(int id);

	public abstract Edificio findByName(String name);
}

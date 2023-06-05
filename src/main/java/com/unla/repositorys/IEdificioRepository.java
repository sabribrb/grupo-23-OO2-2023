package com.unla.repositorys;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.entities.Edificio;

@Repository("edificioRepository")
public interface IEdificioRepository extends JpaRepository<Edificio, Serializable>{


	public abstract Edificio findByIdEdificio(int idEdificio);

	//public abstract Edificio findByName(String name);
}

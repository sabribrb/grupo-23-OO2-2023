package com.unla.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="estacionamiento")
public class Estacionamiento extends Dispositivo{

	private Set<Integer> lugares= new HashSet<Integer>();

	public Estacionamiento(int idDispositivo, String nombre, LocalDateTime creacion, boolean activo, Edificio edificio,
			Set<Integer> lugares) {
		super(idDispositivo, nombre, creacion, activo, edificio);
		this.lugares = lugares;
	}

	public Estacionamiento(int idDispositivo, String nombre, LocalDateTime creacion, boolean activo,
			Edificio edificio) {
		super(idDispositivo, nombre, creacion, activo, edificio);
	}

	
}

package com.unla.entities;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="estacionamiento")
public class Estacionamiento extends Dispositivo{

	@Column(name="nroPlaza")
	private int nroPlaza;

	public Estacionamiento(int idDispositivo, String nombre, LocalDateTime creacion, boolean activo,
			Set<Evento> eventos, Edificio edificio, int nroPlaza) {
		super(idDispositivo, nombre, creacion, activo, eventos,edificio );
		this.nroPlaza = nroPlaza;
	}

	public Estacionamiento(int idDispositivo, String nombre, LocalDateTime creacion, boolean activo,
			Set<Evento> eventos, Edificio edificio) {
		super(idDispositivo, nombre, creacion, activo, eventos, edificio);
	}

	
}

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
@Table(name="banios")
public class Banios extends Dispositivo {
	
	@Column(name="numBanios")
	private int numBanios;

	public Banios(int idDispositivo, String nombre, LocalDateTime creacion, boolean activo, Set<Evento> eventos,
			int numBanios) {
		super(idDispositivo, nombre, creacion, activo, eventos);
		this.numBanios = numBanios;
	}

	public Banios(int idDispositivo, String nombre, LocalDateTime creacion, boolean activo, Set<Evento> eventos) {
		super(idDispositivo, nombre, creacion, activo, eventos);
	}

	
	
}

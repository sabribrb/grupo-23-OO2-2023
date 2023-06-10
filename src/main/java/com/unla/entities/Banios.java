package com.unla.entities;

import java.time.LocalDateTime;

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
	@Column
	private boolean cerrojo; //si el sensor capta que está en true, significa que alguien ocupa el baño, esto registra un evento?


	public Banios(String nombre, LocalDateTime creacion, boolean activo, Edificio edificio,
			int numBanios, boolean cerrojo) {
		super( nombre, creacion, activo, edificio);
		this.numBanios = numBanios;
		this.cerrojo = cerrojo;
	}



}

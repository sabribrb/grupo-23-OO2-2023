package com.unla.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "banios")
public class Banio extends Dispositivo {

	@Column(name = "numBanios")
	private int numBanio;
	@Column(columnDefinition = "boolean default false")
	private boolean cerrojo; // si el sensor capta que está en true, significa que alguien ocupa el baño,
								// esto registra un evento?

	public Banio() {

	}

	public Banio(String nombre, boolean activo, Edificio edificio, int numBanios) {
		super(nombre, activo, edificio);
		this.numBanio = numBanios;
		setCerrojo(false);
	}

	@Override
	public String toString() {

		return "Banios{" +
				"numBanio=" + numBanio +
				", cerrojo=" + cerrojo +
				", idDispositivo=" + idDispositivo +
				", nombre='" + nombre + '\'' +
				", creacion=" + creacion +
				", activo=" + activo +
				", eventos=" + eventos +
				'}';
	}


}

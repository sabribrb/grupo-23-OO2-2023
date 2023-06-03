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

	public Banios(String nombre, LocalDateTime creacion, int numBanios) {
		super(nombre, creacion);
		this.numBanios = numBanios;
	}

	public Banios(String nombre, LocalDateTime creacion) {
		super(nombre, creacion);
	}

	
}

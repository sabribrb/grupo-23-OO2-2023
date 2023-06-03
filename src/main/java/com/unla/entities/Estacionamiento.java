package com.unla.entities;

import java.time.LocalDateTime;

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

	public Estacionamiento(String nombre, LocalDateTime creacion, int nroPlaza) {
		super(nombre, creacion);
		this.nroPlaza = nroPlaza;
	}

	public Estacionamiento(String nombre, LocalDateTime creacion) {
		super(nombre, creacion);
	}
	
	
}

package com.unla.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="Alumbrado")
public class Alumbrado extends Dispositivo{

	@Column(name="numAula")
	private int numAula;
	
	public Alumbrado() {}

	public Alumbrado(String nombre, boolean activo, Edificio edificio, int numAula) {
		super(nombre, activo, edificio);
		this.numAula = numAula;
	}

	
}

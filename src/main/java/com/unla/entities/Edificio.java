package com.unla.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="edificio")
public class Edificio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEdificio;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy= "edificio")
	private Set<Dispositivo> dispositivos = new HashSet<Dispositivo>();

	public Edificio() {
		super();
	}

	public Edificio(int idEdificio, String nombre, Set<Dispositivo> dispositivos) {
		super();
		this.idEdificio = idEdificio;
		this.nombre = nombre;
		this.dispositivos = dispositivos;
	}

	public Edificio(String nombre, Set<Dispositivo> dispositivos) {
		super();
		this.nombre = nombre;
		this.dispositivos = dispositivos;
	}

	@Override
	public String toString() {
		return "Edificio{" +
				"idEdificio=" + idEdificio +
				", nombre='" + nombre + '\'' +
				", dispositivos=" + dispositivos +
				'}';
	}
}

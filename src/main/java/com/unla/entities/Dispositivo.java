package com.unla.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="dispositivo")
public abstract class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idDispositivo;
	
	@Column(name="nombre")
	protected String nombre;
	
	@Column(name="creacion")
	@CreationTimestamp
	protected LocalDateTime creacion;
	
	public Dispositivo(String nombre, LocalDateTime creacion) {
		super();
		this.nombre = nombre;
		this.creacion = creacion;
	}

	public Dispositivo(int id, String nombre, LocalDateTime creacion) {
		super();
		this.idDispositivo = id;
		this.nombre = nombre;
		this.creacion = creacion;
	}

	public Dispositivo() {
		super();
	}
	
	
}

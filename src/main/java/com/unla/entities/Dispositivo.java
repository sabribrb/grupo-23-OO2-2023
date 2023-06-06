package com.unla.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)
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

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "dispositivo")
	protected Set<Evento> eventos= new HashSet<Evento>();

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

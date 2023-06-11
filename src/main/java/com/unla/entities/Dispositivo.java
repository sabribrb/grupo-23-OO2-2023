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

	@Column(name="activo")
	protected boolean activo;

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "dispositivo")
	protected Set<Evento> eventos= new HashSet<Evento>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_edificio", nullable = true)
	private Edificio edificio;

	public Dispositivo(String nombre, LocalDateTime creacion) {
		super();
	}

	public Dispositivo(int idDispositivo, String nombre, LocalDateTime creacion, boolean activo, Set<Evento> eventos,
			Edificio edificio) {
		super();
		this.idDispositivo = idDispositivo;
		this.nombre = nombre;
		this.creacion = creacion;
		this.activo = activo;
		this.eventos = eventos;
		this.edificio = edificio;
	}

	public Dispositivo(String nombre, LocalDateTime creacion, boolean activo, Set<Evento> eventos, Edificio edificio) {
		super();
		this.nombre = nombre;
		this.creacion = creacion;
		this.activo = activo;
		this.eventos = eventos;
		this.edificio = edificio;
	}

	public Dispositivo(int idDispositivo, String nombre, LocalDateTime creacion, boolean activo, Edificio edificio) {
		super();
		this.idDispositivo = idDispositivo;
		this.nombre = nombre;
		this.creacion = creacion;
		this.activo = activo;
		this.edificio = edificio;
	}


}

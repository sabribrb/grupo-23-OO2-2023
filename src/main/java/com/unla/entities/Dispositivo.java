package com.unla.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
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
	
<<<<<<< Updated upstream
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

=======
	@Column(name="activo")
	protected boolean activo;

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "dispositivo")
	protected Set<Evento> eventos= new HashSet<Evento>();
	
>>>>>>> Stashed changes
	public Dispositivo() {
		super();
	}

	public Dispositivo(String nombre, LocalDateTime creacion, boolean activo, Set<Evento> eventos) {
		super();
		this.nombre = nombre;
		this.creacion = creacion;
		this.activo = activo;
		this.eventos = eventos;
	}

	public Dispositivo(int idDispositivo, String nombre, LocalDateTime creacion, boolean activo, Set<Evento> eventos) {
		super();
		this.idDispositivo = idDispositivo;
		this.nombre = nombre;
		this.creacion = creacion;
		this.activo = activo;
		this.eventos = eventos;
	}
	
}

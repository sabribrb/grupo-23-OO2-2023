package com.unla.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
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

	//atributo para la baja logica
	
	@Column(name="activo", columnDefinition = "boolean default true")
	protected boolean activo;

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "dispositivo")
	protected Set<Evento> eventos= new HashSet<Evento>();

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_edificio", nullable = true)
	protected Edificio edificio;

	public Dispositivo() {
	}

	public Dispositivo(String nombre, boolean activo, Edificio edificio) {
        this.nombre = nombre;
        this.activo= activo;
		this.edificio= edificio;
	}

	public Dispositivo(String nombre, LocalDateTime creacion, boolean activo , Edificio edificio, Set<Evento> eventos) {
		super();
		this.nombre = nombre;
		this.creacion = creacion;
		this.activo = activo;
		this.eventos = eventos;
		this.edificio= edificio;
	}

	public Dispositivo(int idDispositivo, String nombre, LocalDateTime creacion, boolean activo, Set<Evento> eventos, Edificio edificio) {

		this.idDispositivo = idDispositivo;
		this.nombre = nombre;
		this.creacion = creacion;
		this.activo = activo;
		this.eventos = eventos;
		this.edificio= edificio;
	}

	@Override
	public String toString() {
		return "Dispositivo{" +
				"idDispositivo=" + idDispositivo +
				", nombre='" + nombre + '\'' +
				", creacion=" + creacion +
				", activo=" + activo +
				", eventos=" + eventos +
				'}';
	}

	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCreacion(LocalDateTime creacion) {
		this.creacion = creacion;
	}
	 @Value("${dispositivo.activo.default:true}")
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

}

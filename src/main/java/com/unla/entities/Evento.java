package com.unla.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
@Table(name="evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvento;
	
	@Column(name="horaEvento")
	@CreationTimestamp
	private LocalDateTime horaEvento;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="estado")
	private boolean estado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_dispositivo", nullable = true)
	private Dispositivo dispositivo;

	public Evento() {
		super();
	}

	public Evento(LocalDateTime horaEvento, String descripcion, boolean estado, Dispositivo dispositivo) {
		super();
		this.horaEvento = horaEvento;
		this.descripcion = descripcion;
		this.estado = estado;
		this.dispositivo = dispositivo;
	}

	public Evento(int idEvento, LocalDateTime horaEvento, String descripcion, boolean estado, Dispositivo dispositivo) {
		super();
		this.idEvento = idEvento;
		this.horaEvento = horaEvento;
		this.descripcion = descripcion;
		this.estado = estado;
		this.dispositivo = dispositivo;

	}

	public Evento() {
		super();
	}
	
	
}

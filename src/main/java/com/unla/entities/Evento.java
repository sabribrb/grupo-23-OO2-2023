package com.unla.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

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
	
	@OneToMany(fetch=FetchType.LAZY)
	private Set<Dispositivo> dispositivos = new HashSet<Dispositivo>();

	public Evento(LocalDateTime horaEvento, String descripcion, boolean estado, Set<Dispositivo> dispositivos) {
		super();
		this.horaEvento = horaEvento;
		this.descripcion = descripcion;
		this.estado = estado;
		this.dispositivos = dispositivos;
	}

	public Evento(int idEvento, LocalDateTime horaEvento, String descripcion, boolean estado,
			Set<Dispositivo> dispositivos) {
		super();
		this.idEvento = idEvento;
		this.horaEvento = horaEvento;
		this.descripcion = descripcion;
		this.estado = estado;
		this.dispositivos = dispositivos;
	}

	public Evento() {
		super();
	}
	
	
}

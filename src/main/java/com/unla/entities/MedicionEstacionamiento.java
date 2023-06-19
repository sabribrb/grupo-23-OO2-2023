package com.unla.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="medicionEstacionamiento")
public class MedicionEstacionamiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedicion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_dispositivo", nullable = true)
	private Dispositivo dispositivo;
	
	@Column(name="fechaHoraRegistro")
	@CreationTimestamp
	private LocalDateTime fechaHoraRegistro;
	
	@Column(name="numeroLugar")
	private int numeroLugar;
	
	@Column(name="ocupado",columnDefinition = "boolean default false",nullable = true)
	private boolean ocupado;
	
	public MedicionEstacionamiento(int idMedicion, Dispositivo dispositivo, LocalDateTime fechaHoraRegistro,
			int numeroLugar, boolean ocupado) {
		super();
		this.idMedicion = idMedicion;
		this.dispositivo = dispositivo;
		this.fechaHoraRegistro = fechaHoraRegistro;
		this.numeroLugar = numeroLugar;
		this.ocupado = ocupado;
	}

	public MedicionEstacionamiento(Dispositivo dispositivo, LocalDateTime fechaHoraRegistro, int numeroLugar,
			boolean ocupado) {
		super();
		this.dispositivo = dispositivo;
		this.fechaHoraRegistro = fechaHoraRegistro;
		this.numeroLugar = numeroLugar;
		this.ocupado = ocupado;
	}

	public MedicionEstacionamiento() {
		super();
	}

}

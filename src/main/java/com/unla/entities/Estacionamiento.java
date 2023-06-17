package com.unla.entities;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="estacionamiento")
public class Estacionamiento extends Dispositivo{

    @Column(name = "lugares", columnDefinition="BIGINT")
	private Set<Integer> lugares= new HashSet<Integer>();

	public Estacionamiento(String nombre, boolean activo, Edificio edificio, Set<Integer> lugares) {
		super(nombre, activo, edificio);
		this.lugares = lugares;
	}

	public Estacionamiento() {
		super();
	}
	
}

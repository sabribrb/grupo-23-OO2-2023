package com.unla.entities;



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

@Getter 
@Setter
@Entity
@Table(name="medicionAlumbrado")
public class MedicionAlumbrado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedicionAlum;

	@Column(name="hayGente")
	private boolean hayGente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_dispositivo", nullable = true)
	private Dispositivo dispositivo;
	
	public MedicionAlumbrado() {
		
	}

	public MedicionAlumbrado( boolean hayGente,Dispositivo dispositivo) {
		super();
	
		this.hayGente = hayGente;
		this.dispositivo = dispositivo;
	}
	
	
}

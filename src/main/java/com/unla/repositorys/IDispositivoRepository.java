package com.unla.repositorys;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.entities.Dispositivo;

@Repository("dispositivoRepository")
public interface IDispositivoRepository extends JpaRepository<Dispositivo, Serializable> {

	public Dispositivo findByIdDispositivo(int idDispositivo);

	//public Dispositivo findByNombreDispositivo(String nombre);
}

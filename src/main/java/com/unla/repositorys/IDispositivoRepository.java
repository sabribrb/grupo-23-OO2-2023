package com.unla.repositorys;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.entities.Dispositivo;
import com.unla.entities.Estacionamiento;

@Repository("dispositivoRepository")
public interface IDispositivoRepository extends JpaRepository<Dispositivo, Serializable> {

	public Dispositivo findByIdDispositivo(int idDispositivo);
	
	@Query("SELECT e FROM Estacionamiento e")
	public List<Dispositivo> getAllEstacionamiento();
	
	@Query("SELECT e FROM Estacionamiento e WHERE DATE(e.creacion) = :creacion")
    List<Estacionamiento> findEstacionamientosByFecha(@Param("creacion") LocalDateTime creacion);

	
	@Query("SELECT e FROM Estacionamiento e WHERE e.activo = (:activo)")
	 List<Estacionamiento> findEstacionamientosByEnabled(@Param("activo") boolean activo); 
	
	//public Dispositivo findByNombreDispositivo(String nombre);
}

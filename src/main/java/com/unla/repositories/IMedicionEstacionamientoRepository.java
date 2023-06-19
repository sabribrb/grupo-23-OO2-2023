package com.unla.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.entities.MedicionEstacionamiento;


@Repository("medicioEstacionamientoRepository")
public interface IMedicionEstacionamientoRepository extends JpaRepository<MedicionEstacionamiento, Serializable>{

	@Query("SELECT m FROM MedicionEstacionamiento m WHERE m.idMedicion = :idMedicion")
    MedicionEstacionamiento findByIdMedcicionEstacionamiento(@Param("idMedicion") int idMedicion);
	
	@Query("SELECT m FROM MedicionEstacionamiento m")
	public List<MedicionEstacionamiento> getAllMedicionesEstacionamiento();
	
}

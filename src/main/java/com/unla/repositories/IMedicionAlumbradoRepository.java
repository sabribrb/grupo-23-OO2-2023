package com.unla.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.entities.MedicionAlumbrado;


@Repository("medicionAlumbradoRepository")
public interface IMedicionAlumbradoRepository extends JpaRepository<MedicionAlumbrado, Serializable>{


	@Query("SELECT m FROM MedicionAlumbrado m")
	public List<MedicionAlumbrado> getAllMedicionesAlumbrado();
	
	@Query("SELECT m FROM MedicionAlumbrado m WHERE m.idMedicionAlum = :idMedicionAlum")
    MedicionAlumbrado findByIdMedcicionAlumbrado(@Param("idMedicionAlum") int idMedicionAlum);
}

package com.unla.repositories;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.entities.Banio;
import com.unla.entities.Evento;

@Repository("eventoRepository")
public interface IEventoRepository extends JpaRepository<Evento, Serializable> {

	public abstract Evento findByIdEvento(int idEvento);

	@Query("SELECT e FROM Evento e JOIN FETCH e.dispositivo d WHERE d.idDispositivo = (:idDispositivo)")
	List<Evento> findEventosByDispositivo(@Param("idDispositivo") int idDispositivo);

	@Query("SELECT e FROM Evento e WHERE DATE(e.horaEvento) = :horaEvento")
	List<Evento> findEventosByFecha(@Param("horaEvento") LocalDateTime horaEvento);

	@Query("SELECT e FROM Evento e WHERE e.horaEvento >= (:fecha) AND e.dispositivo.idDispositivo = (:dispositivoId)")
	List<Evento> findByHoraEventoAndDispositivoId(@Param("fecha") LocalDateTime fecha,
			@Param("dispositivoId") int dispositivoId);

	@Query("SELECT b FROM Evento b")
	public List<Evento> getAllEventos();
}

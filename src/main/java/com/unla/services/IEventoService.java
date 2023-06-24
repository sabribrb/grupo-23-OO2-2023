package com.unla.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.unla.entities.Evento;

public interface IEventoService {

	public List<Evento> getAll();

	public Evento findByIdEvento(int idEvento);

	public Evento insertOrUpdate(Evento e);

	public boolean remove(int id);

	@ModelAttribute("Evento")
	public List<Evento> getAllEventos();

	List<Evento> findEventosByFecha(@Param("horaEvento") LocalDateTime horaEvento);

	List<Evento> findEventosByDispositivo(@Param("idDispositivo") int idDispositivo);

	List<Evento> findByHoraEventoAndDispositivoId(@Param("fecha") LocalDateTime fecha,
			@Param("dispositivoId") Integer dispositivoId);
}

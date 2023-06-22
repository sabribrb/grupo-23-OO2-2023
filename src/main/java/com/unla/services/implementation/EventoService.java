package com.unla.services.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.entities.Banio;
import com.unla.entities.Evento;
import com.unla.repositories.IEventoRepository;
import com.unla.services.IEventoService;

@Service
public class EventoService implements IEventoService{

	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;
	
	@Override
	public List<Evento> getAll() {
		return eventoRepository.findAll();
	}

	@Override
	public Evento findByIdEvento(int idEvento) {
		return eventoRepository.findByIdEvento(idEvento);
	}

	@Override
	public Evento insertOrUpdate(Evento e) {
		Evento nuevoEvento=eventoRepository.save(e);
		return nuevoEvento;
	}

	@Override
	public boolean remove(int id) {
		try {
			eventoRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Evento> getAllEventos() {
		return eventoRepository.getAllEventos();
	}

	@Override
	public List<Evento> findEventosByFecha(LocalDateTime horaEvento) {
		return eventoRepository.findEventosByFecha(horaEvento);
	}

	@Override
	public List<Evento> findEventosByDispositivo(int idDispositivo) {
		return eventoRepository.findEventosByDispositivo(idDispositivo);
	}

	@Override
	public List<Evento> findByHoraEventoAndDispositivoId(LocalDateTime fecha, int dispositivoId) {
		return eventoRepository.findByHoraEventoAndDispositivoId(fecha, dispositivoId);
	}

}

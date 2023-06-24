package com.unla.controllers;

import com.unla.entities.Evento;
import com.unla.helpers.ViewRouteHelper;
import com.unla.services.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;

	@PreAuthorize("hasRole('ROLE_AUDIT')" + "|| hasRole('ROLE_ADMIN')")
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelAndView.addObject("username", user.getUsername());
		modelAndView.addObject("evento", eventoService.getAllEventos());
		return modelAndView;
	}

	@GetMapping("/filtrar")
	public String filtrarEventos(@RequestParam(name = "fecha", required = false) LocalDate fecha,
			@RequestParam(name = "idDispositivo", required = false) Integer idDispositivo, Model model) {
		LocalDateTime convertir = fecha.atTime(LocalTime.of(0, 0, 0));
		List<Evento> evento = eventoService.findByHoraEventoAndDispositivoId(convertir, idDispositivo);
		model.addAttribute("evento", evento);
		model.addAttribute("fecha", fecha);
		model.addAttribute("idDispositivo", idDispositivo);
		return ViewRouteHelper.INDEX;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView(ViewRouteHelper.ROUTE);
	}
}

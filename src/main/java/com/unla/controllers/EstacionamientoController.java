package com.unla.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.unla.entities.Edificio;
import com.unla.entities.Estacionamiento;
import com.unla.helpers.ViewRouteHelper;
import com.unla.services.IDispositivoService;
import com.unla.services.IEdificioService;

@Controller
@RequestMapping("/estacionamiento")
public class EstacionamientoController {

	@Autowired
	private IEdificioService edificioService;

	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;

	private ModelMapper modelMapper = new ModelMapper();

	@GetMapping("/todos-los-estacionamientos")
	public ModelAndView getEstacionamientos() {
		ModelAndView mV = new ModelAndView();
		mV.setViewName(ViewRouteHelper.REPORTES_ESTACIONAMIENTOS);
		mV.addObject("estacionamiento", dispositivoService.getAllEstacionamiento());
		return mV;
	}

	@GetMapping("/new")
	public ModelAndView newEstacionamiento() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.NEW_ESTACIONAMIENTO);
		mV.addObject("estacionamiento", new Estacionamiento());
		List<Edificio> edificios = edificioService.getAll();
		mV.addObject("edificios", edificios);
		return mV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("estacionamiento") Estacionamiento estacionamiento,
			@RequestParam("edificioId") int edificioId) {
		Edificio edificio = edificioService.findByIdEdificio(edificioId);
		estacionamiento.setActivo(true);
		estacionamiento.setEdificio(edificio);
		dispositivoService.insertOrUpdate(modelMapper.map(estacionamiento, Estacionamiento.class));
		return new RedirectView(ViewRouteHelper.REPORTES_ESTACIONAMIENTOS);
	}

    @GetMapping("/delete")
    public RedirectView delete(@RequestParam(value="id") int id){
        dispositivoService.removeDispositivo(id);
        return new RedirectView(ViewRouteHelper.REPORTES_ESTACIONAMIENTOS);
    }
}

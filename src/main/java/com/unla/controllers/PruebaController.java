package com.unla.controllers;


import com.unla.helpers.ViewRouteHelper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.services.IEventoService;


@Controller
@RequestMapping("/")
public class PruebaController {

	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;
	
	@GetMapping("/login")
	public ModelAndView inicio(){ 
		ModelAndView mV = new ModelAndView();
		mV.setViewName(ViewRouteHelper.MEDICION_EST_FORM);
		mV.addObject("evento", eventoService.getAllEventos());
		return mV;
	}


}


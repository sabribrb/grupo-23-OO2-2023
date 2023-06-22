package com.unla.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.entities.Estacionamiento;
import com.unla.entities.MedicionEstacionamiento;
import com.unla.helpers.ViewRouteHelper;
import com.unla.services.IMedicionEstacionamientoService;

@Controller
@RequestMapping("/mediciones-estacionamiento")
public class MedicionEstacionamientoController {

	@Autowired
	@Qualifier("medicionEstacionamientoService")
	private IMedicionEstacionamientoService medicionEstacionamientoService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
    @GetMapping("/todas")
    public ModelAndView getEstacionamientos() {
        ModelAndView mV = new ModelAndView();
        mV.setViewName(ViewRouteHelper.REPORTES_MEDICIONES);
        mV.addObject("medicionEstacionamiento", medicionEstacionamientoService.getAllMedicionesEstacionamiento());
        return mV;
    }
    
    @GetMapping("/new")
    public ModelAndView newEstacionamiento() {
        ModelAndView mV = new ModelAndView(ViewRouteHelper.NEW_MEDICION);
        mV.addObject("medicionEstacionamiento", new MedicionEstacionamiento());
        return mV;
    }

    @PostMapping("/create")
    public RedirectView create(@ModelAttribute("medicionEstacionamiento") MedicionEstacionamiento medicion) {
    	medicionEstacionamientoService.guardarMedicionEstacionamiento(modelMapper.map(medicion, MedicionEstacionamiento.class));
        return new RedirectView(ViewRouteHelper.REPORTES_MEDICIONES);
    }
    
    
}

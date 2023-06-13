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
	
    @GetMapping("/form")
    public String mostrarFormularioMedicionEstacionamiento(Model model) {
        model.addAttribute("medicionEstacionamiento", new MedicionEstacionamiento());
    	return ViewRouteHelper.MEDICION_EST_FORM;
    }

    @PostMapping("/guardar")
    public String guardarMedicionEstacionamiento(
            @ModelAttribute("medicionEstacionamiento") MedicionEstacionamiento medicionEstacionamiento) {
        medicionEstacionamientoService.guardarMedicionEstacionamiento(medicionEstacionamiento);
        return "redirect:/login";
    }
}

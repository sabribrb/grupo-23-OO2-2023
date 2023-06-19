package com.unla.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.unla.entities.MedicionAlumbrado;
import com.unla.services.IMedicionAlumbradoService;


@Controller
@RequestMapping("/medicion_alumbrado")
public class MedicionAlumbradoController {

	  @Autowired
	  @Qualifier("medicionAlumbradoService")
	  private IMedicionAlumbradoService medicionAlumbradoService;
	  
	  private ModelMapper modelMapper = new ModelMapper();
	  

	    @PostMapping("/guardar")
	    public String guardarMedicionAlumbrado(
	        @ModelAttribute("medicionAlumbrado") MedicionAlumbrado medicionAlumbrado) {
	        medicionAlumbradoService.guardarMedicionAlumbrado(medicionAlumbrado);
	        return "redirect:/login";
	    }
}

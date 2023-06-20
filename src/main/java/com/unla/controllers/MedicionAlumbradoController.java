package com.unla.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.view.RedirectView;


import com.unla.entities.MedicionAlumbrado;
import com.unla.helpers.ViewRouteHelper;
import com.unla.services.IMedicionAlumbradoService;


@Controller
@RequestMapping("/medicion_alumbrado")
public class MedicionAlumbradoController {

	  @Autowired
	  @Qualifier("medicionAlumbradoService")
	  private IMedicionAlumbradoService medicionAlumbradoService;
	  
	  private ModelMapper modelMapper = new ModelMapper();
	  

	    @PostMapping("/registrar")
	    public RedirectView registrarMedicionAlumbrado(@ModelAttribute("medicionAlumbrado") MedicionAlumbrado medicionAlumbrado) {
	        medicionAlumbradoService.registrarMedicionAlumbrado(modelMapper.map(medicionAlumbrado, MedicionAlumbrado.class));
	        return new RedirectView(ViewRouteHelper.REGISTRO_ALUMBRADO);
	        
	    }

}

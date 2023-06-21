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
import org.springframework.web.servlet.ModelAndView;
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
	  

	    @GetMapping("/new")
	    public ModelAndView registrarEvento() {
	        ModelAndView mV = new ModelAndView(ViewRouteHelper.REGISTRO_ALUMBRADO);
	        mV.addObject("medicionAlumbrado", new MedicionAlumbrado());
	        return mV;
	    }

}

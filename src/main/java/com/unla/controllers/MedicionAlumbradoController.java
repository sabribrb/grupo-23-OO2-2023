package com.unla.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
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
	  
	   @PreAuthorize("hasRole('ROLE_AUDIT')" +
	            "|| hasRole('ROLE_ADMIN')")
	    @GetMapping("")
	    public ModelAndView getMedicionesAlumbrado() {
	        ModelAndView mV = new ModelAndView();
	        mV.setViewName(ViewRouteHelper.REPORTES_ALUMBRADO_MED);
	        mV.addObject("medicionAlumbrado", medicionAlumbradoService.getAllMedicionesAlumbrado());
	        return mV;
	    }
	    
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
	    @GetMapping("/new")
	    public ModelAndView registroMedicionAlumbrado() {
	        ModelAndView mV = new ModelAndView(ViewRouteHelper.REGISTRO_ALUMBRADO);
	        mV.addObject("medicionAlumbrado", new MedicionAlumbrado());
	        return mV;
	    }

	    @PostMapping("/create")
	    public RedirectView create(@ModelAttribute("medicionAlumbrado") MedicionAlumbrado medicion) {
	    	medicionAlumbradoService.registrarMedicionAlumbrado(modelMapper.map(medicion, MedicionAlumbrado.class));
	        return new RedirectView(ViewRouteHelper.ALUMBRADO_MEDICION_ROOT);
	    }
	    
}

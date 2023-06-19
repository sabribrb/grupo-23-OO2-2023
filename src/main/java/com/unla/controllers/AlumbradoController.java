package com.unla.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.helpers.ViewRouteHelper;
import com.unla.services.IDispositivoService;

@Controller
@RequestMapping("/Alumbrado")
public class AlumbradoController {
	 @Autowired
	    @Qualifier("dispositivoService")
	    private IDispositivoService dispositivoService;
	 
	    @GetMapping("/todos-las-aulas")
	    public ModelAndView getAlumbrado() {
	        ModelAndView mV = new ModelAndView();
	        mV.setViewName(ViewRouteHelper.REPORTES_ALUMBRADO);
	        mV.addObject("alumbrado", dispositivoService.getAllAlumbrado());
	        return mV;
	    }

  
	
}

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

import com.unla.entities.Alumbrado;
import com.unla.entities.Edificio;
import com.unla.helpers.ViewRouteHelper;
import com.unla.services.IDispositivoService;
import com.unla.services.IEdificioService;

@Controller
@RequestMapping("/alumbrado")
public class AlumbradoController {
	
	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;

	@Autowired
	@Qualifier("edificioService")
	private IEdificioService edificioService;

	    @GetMapping("")
	    public ModelAndView getAlumbrado() {
	        ModelAndView mV = new ModelAndView();
	        mV.setViewName(ViewRouteHelper.REPORTES_ALUMBRADO);
	        mV.addObject("alumbrado", dispositivoService.getAllAlumbrado());
	        return mV;
	    }
  
	    @GetMapping("/new")
	    public ModelAndView newAlumbrado() {
	    	ModelAndView mV= new ModelAndView(ViewRouteHelper.NEW_ALUMBRADO);
	    	mV.addObject("alumbrado", new Alumbrado());
	    	List<Edificio> edificios = edificioService.getAll();
	    	mV.addObject("edificios",edificios);
	    	return mV;
	    }
	    
	    @PostMapping("/create")
	    public RedirectView create(@ModelAttribute("alumbrado") Alumbrado alumbrado,@RequestParam("edificioId") int edificioId) {
	        Edificio edificio = edificioService.findByIdEdificio(edificioId);
	        alumbrado.setActivo(true);
	        alumbrado.setEdificio(edificio);
	        dispositivoService.insertOrUpdate(modelMapper.map(alumbrado, Alumbrado.class));
	        return new RedirectView(ViewRouteHelper.ALUMBRADO_ROOT);
	    }

	    @GetMapping("/delete")
	    public RedirectView delete(@RequestParam(value="id") int id){
	        dispositivoService.remove(id);
	        return new RedirectView(ViewRouteHelper.ALUMBRADO_ROOT);
	    }
	
}

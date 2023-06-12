package com.unla.controllers;

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
import com.unla.entities.Estacionamiento;
import com.unla.helpers.ViewRouteHelper;
import com.unla.services.IDispositivoService;

@Controller
@RequestMapping("/estacionamiento")
public class EstacionamientoController {

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
        return mV;
    }

    @PostMapping("/create")
    public RedirectView create(@ModelAttribute("estacionamiento") Estacionamiento estacionamiento) {
        dispositivoService.insertOrUpdate(modelMapper.map(estacionamiento, Estacionamiento.class));
        return new RedirectView(ViewRouteHelper.REPORTES_ESTACIONAMIENTOS);
    }
}

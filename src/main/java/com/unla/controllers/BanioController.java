package com.unla.controllers;

import com.unla.entities.Banio;
import com.unla.helpers.ViewRouteHelper;
import com.unla.services.IDispositivoService;
import com.unla.services.IMedicionBanioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/banios")
public class BanioController {

    @Autowired
    @Qualifier("dispositivoService")
    private IDispositivoService dispositivoService;

    @Autowired
    @Qualifier("medicionBanioService")
    private IMedicionBanioService medicionBanioService;


    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/todos-los-banios")
    public ModelAndView getBanios() {
        ModelAndView mV = new ModelAndView();
        mV.setViewName(ViewRouteHelper.REPORTES_BANIOS);
        mV.addObject("banios", dispositivoService.getAllBanios());
        return mV;
    }


    @GetMapping("/new")
    public ModelAndView newBanio() {
        ModelAndView mV = new ModelAndView(ViewRouteHelper.NEW_BANIO);
        mV.addObject("banio", new Banio());
        return mV;
    }

    @PostMapping("/create")
    public RedirectView create(@ModelAttribute("banio") Banio banio) {
        banio.setNombre("dispositivo baño");
        dispositivoService.insertOrUpdate(modelMapper.map(banio, Banio.class));
        return new RedirectView(ViewRouteHelper.REPORTES_BANIOS);
    }

    @GetMapping("/registrar")
    public RedirectView recordEvent(@RequestParam int id, @RequestParam(defaultValue = "true") boolean cambiar) throws Exception {
        //agregar parametro ocupar vs liberar
        Banio banio= dispositivoService.getBanioById(id);
        if(cambiar) medicionBanioService.cerrarPuerta(banio);
        else {medicionBanioService.liberarBanio(banio);}
        return new RedirectView(ViewRouteHelper.REGISTRO_BANIO);
    }


    //TODO: baja(logica) y modificacion, filtros en el getAllBanios, mejorar vistas

}



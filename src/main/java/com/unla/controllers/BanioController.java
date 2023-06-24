package com.unla.controllers;

import com.unla.entities.Banio;
import com.unla.entities.Edificio;
import com.unla.helpers.ViewRouteHelper;
import com.unla.services.IDispositivoService;
import com.unla.services.IEdificioService;
import com.unla.services.IMedicionBanioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/banios")
public class BanioController {

    @Autowired
    @Qualifier("dispositivoService")
    private IDispositivoService dispositivoService;
 @Autowired
    @Qualifier("edificioService")
    private IEdificioService edificioService;

    @Autowired
    @Qualifier("medicionBanioService")
    private IMedicionBanioService medicionBanioService;


    private ModelMapper modelMapper = new ModelMapper();

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mV = new ModelAndView();
        mV.setViewName(ViewRouteHelper.INDEX_BANIOS);
        mV.addObject("banios", dispositivoService.getAllBanios());
        return mV;
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/new")
    public ModelAndView create() {
        ModelAndView mV = new ModelAndView(ViewRouteHelper.NEW_BANIO);
        mV.addObject("banio", new Banio());
        List<Edificio> edificios = edificioService.getAll();
        mV.addObject("edificios", edificios);
        return mV;
    }

    @PostMapping("/create")
    public RedirectView create(@ModelAttribute("banio") Banio banio,@RequestParam("edificioId") int edificioId) {
        Edificio edificio = edificioService.findByIdEdificio(edificioId);
        banio.setActivo(true);
        banio.setEdificio(edificio);
        dispositivoService.insertOrUpdate(modelMapper.map(banio, Banio.class));
        return new RedirectView(ViewRouteHelper.BANIO_ROOT);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/registrar")
    public ModelAndView recordEvent(@RequestParam(value = "id") int id) throws Exception {
        //agregar parametro ocupar vs liberar
        Banio banio= dispositivoService.getBanioById(id);
        if(!banio.isCerrojo()) medicionBanioService.cerrarPuerta(banio);
        else {medicionBanioService.liberarBanio(banio);}
        return new ModelAndView(ViewRouteHelper.BANIO_EVENTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")//delete
    @GetMapping("/delete")
    public RedirectView delete(@RequestParam(value="id") int id){
        dispositivoService.removeDispositivo(id);
        return new RedirectView(ViewRouteHelper.BANIO_ROOT);
    }

    @GetMapping("/")
    public RedirectView redirectToBanioIndex() {
        return new RedirectView(ViewRouteHelper.BANIO_ROOT);
    }


}



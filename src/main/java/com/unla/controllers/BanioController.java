package com.unla.controllers;

import com.unla.entities.Banio;
import com.unla.helpers.ViewRouteHelper;
import com.unla.services.IDispositivoService;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/banios")
public class BanioController {
    @Autowired
    @Qualifier("dispositivoService")
    private IDispositivoService dispositivoService;

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

    //TODO: baja(logica) y modificacion, filtros en el getAllBanios, mejorar vistas

}



package com.unla.controllers;

import com.unla.helpers.ViewRouteHelper;
import com.unla.services.IEdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class PruebaController {
    @Autowired
    @Qualifier("edificioService")
    public IEdificioService edificioService;


    //mostrar todos los edificios
    @GetMapping("/edificio/todos-los-edificios")
    public ModelAndView getEdificios() {
        ModelAndView mV = new ModelAndView();
        mV.setViewName(ViewRouteHelper.REPORTES_EDIFICIOS);
        mV.addObject("edificio", edificioService.getAll());
        return mV;
    }

//TODO: eliminar este controller o dejar unno de Home, una vez que setee la config de security, eliminar templates del permitAll



}


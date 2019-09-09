package com.idwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nominas/")
public class NominasController {

	@RequestMapping("/gestion/nominas")
	public String nominas() {
        return "secure/nominas/gestion_nominas";
    }
	
	@RequestMapping("/gestion/trabajadores")
	public String gestionarTrabajadores() {
        return "secure/nominas/gestion_trabajadores";
    }
	
}

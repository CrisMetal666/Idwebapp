package com.idwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/compras/")
public class ComprasController {

	@RequestMapping("/autorizar")
	public String autorizar() {
        return "secure/compras/autorizar_compras";
    }
	
	@RequestMapping("/gestion/compras")
	public String gestionarCompras() {
        return "secure/compras/gestion_compras";
    }
	
	@RequestMapping("/gestion/proveedores")
	public String gestionarProveedores() {
        return "secure/compras/gestion_proveedores";
    }
}

package com.idwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ventas/")
public class VentasController {

	@RequestMapping("/gestion/clientes")
	public String autorizar() {
        return "secure/ventas/gestion_clientes";
    }
	
	@RequestMapping("/gestion/facturas")
	public String gestionarCompras() {
        return "secure/ventas/gestion_facturas";
    }
	
	@RequestMapping("/gestion/presupuestos")
	public String gestionarProveedores() {
        return "secure/ventas/gestion_presupuestos";
    }
}

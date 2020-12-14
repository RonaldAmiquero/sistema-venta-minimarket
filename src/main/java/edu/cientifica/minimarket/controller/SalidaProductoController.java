package edu.cientifica.minimarket.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/salidaproducto")
public class SalidaProductoController {
	
	@GetMapping("/")
	public String interfazSalidaProducto(Model model, HttpServletRequest request) {
		
				
		return "salidaProducto";
	}

}

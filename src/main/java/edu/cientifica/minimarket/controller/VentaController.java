package edu.cientifica.minimarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/venta")
public class VentaController {

	@GetMapping("/")
	public String interfazVenta(Model model) {
		
		return "realizarVenta";
	}
}

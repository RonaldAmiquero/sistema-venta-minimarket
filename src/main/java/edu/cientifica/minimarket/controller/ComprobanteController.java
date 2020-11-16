package edu.cientifica.minimarket.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.cientifica.minimarket.model.ComprobantePago;

@Controller
@RequestMapping("/comprobante")
public class ComprobanteController {
    
	@PostMapping("/registrar")
	public String RegistrarComprobante(@ModelAttribute("comprobante") ComprobantePago comprobante, HttpServletRequest request, RedirectAttributes redirectAttrs) {
		
		return "redirect:/venta/";
	}
	
}

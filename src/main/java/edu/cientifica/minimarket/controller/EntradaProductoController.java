package edu.cientifica.minimarket.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.cientifica.minimarket.model.Producto;
import edu.cientifica.minimarket.services.ProductoService;

@Controller
@RequestMapping("/entradaproducto")
public class EntradaProductoController {
	@Autowired
	ProductoService productoService;

	@GetMapping("/")
	public String interfazEntradaProducto(Model model, HttpServletRequest request) {
		model.addAttribute("producto", new Producto());
		return "entradaProductos";
	}
	
	@PostMapping("/producto")
	public String agregarProducto(@ModelAttribute("producto") Producto producto, Model model, HttpServletRequest request) {
		Producto productoBuscadoPorCodigo = productoService.buscarCodBarras(producto.getCodigoBarras());
		model.addAttribute("producto", productoBuscadoPorCodigo);
		return "entradaproducto";
	}
	
	
}

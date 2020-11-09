package edu.cientifica.minimarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import edu.cientifica.minimarket.model.Categoria;
import edu.cientifica.minimarket.model.Producto;
import edu.cientifica.minimarket.services.CategoriaService;


@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	//@Autowired
	//CategoriaService categoriaService;
	
	@GetMapping("/form")
	public String formularioProducto()  {
		/*
		List<Categoria> listaCategorias= null;	
		listaCategorias = categoriaService.listarCategoria();
		Producto producto = new Producto();
		unidadPrivada.setId(unidadPrivadaService.buscarIdMax());
		model.addAttribute("Producto", producto);
		model.addAttribute("listaCategorias",listaCategorias);
		*/
		return "registrarProductos";
		
	}
	/*
	@PostMapping("/registrar")
	public String registrarUnidad( @ModelAttribute("Uprivada") UnidadPrivada unidadPrivada, 
			 Model model, RedirectAttributes atribute) {
		
		int result = 0;
		
		if (errors.hasErrors()) {
			//model.addAttribute("Uprivada", unidadPrivada);
			//return "uprivada_form";
			LOG.info("numero de errores"+errors.getErrorCount());
			return ("redirect:/uprivada/form");
		}
		
		LOG.info("DATOS CAPTURADOS: "+ unidadPrivada.toString());

		try {
			result =unidadPrivadaService.registrarUnidadPrivada(unidadPrivada);
		} catch (Exception e) {
			LOG.info(e.getMessage());
		}

		return "redirect:/uprivada/lista";
	}
*/
	
	
}

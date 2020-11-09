package edu.cientifica.minimarket.controller;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import edu.cientifica.minimarket.model.Categoria;
import edu.cientifica.minimarket.model.Producto;
import edu.cientifica.minimarket.model.Proveedor;
import edu.cientifica.minimarket.services.CategoriaService;
import edu.cientifica.minimarket.services.ProductoService;
import edu.cientifica.minimarket.services.ProveedorService;


@Controller
@RequestMapping("/producto")
public class ProductoController {
	protected final Log LOG =  LogFactory.getLog(this.getClass());
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	ProveedorService proveedorService;
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping("/form")
	public String formularioProducto(Model model)  {
		
		List<Categoria> listaCategorias= null;
		List<Proveedor> listaProveedores=null;
		listaCategorias = categoriaService.listarCategoria();
		listaProveedores = proveedorService.listarProveedores();
		
		Producto producto = new Producto();
		producto.setIdProducto(productoService.asignarId());
		model.addAttribute("Producto", producto);
		model.addAttribute("listaCategorias",listaCategorias);
		model.addAttribute("listaProveedores", listaProveedores);
		return "registrarProductos";
		
	}
	
	@PostMapping("/registrar")
	public String registrarProducto(@ModelAttribute("Producto") Producto producto, 
			BindingResult errors, Model model, RedirectAttributes atribute) {
	
		if (errors.hasErrors()) {
			LOG.info("numero de errores: "+errors.getErrorCount());
			for (ObjectError oe : errors.getAllErrors()) {
				LOG.info("error "+oe.getCode()+" "+oe.getObjectName()+oe.getDefaultMessage());
			}
			return ("registrarProductos");
		}
		

		try {
			int result =productoService.registrarProducto(producto);
		} catch (Exception e) {
			LOG.info("ERROR" + e.getMessage());
		}

		return "redirect:/producto/form";
	}
	
	
}

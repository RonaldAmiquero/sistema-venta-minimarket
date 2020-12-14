package edu.cientifica.minimarket.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.cientifica.minimarket.model.Categoria;
import edu.cientifica.minimarket.model.Producto;
import edu.cientifica.minimarket.model.ProductoProveedor;
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
	public String registrarProducto(@Valid @ModelAttribute("Producto") Producto producto, 
			BindingResult errors, Model model, RedirectAttributes atribute) {
		List<Categoria> listaCategorias= categoriaService.listarCategoria();
		List<Proveedor> listaProveedores= proveedorService.listarProveedores();
		LOG.info("producto: "+producto);
		
		if (errors.hasErrors()) {
			LOG.info("numero de errores: "+errors.getErrorCount());
			for (ObjectError oe : errors.getAllErrors()) {
				LOG.info("error "+oe.getCode()+" "+oe.getObjectName()+ oe.getDefaultMessage());
			}
			
			model.addAttribute("listaCategorias",listaCategorias);
			model.addAttribute("listaProveedores", listaProveedores);
			
			return "registrarProductos";
		}
		
		if(producto.getCategoria().getIdCategoria() == 0 || producto.getProveedor().getId()==0) {
			atribute
			.addFlashAttribute("mensaje", "Debe completar todos los campos 🤷‍")
			.addFlashAttribute("clase", "warning");
		}
		
		try {
			@SuppressWarnings("unused")
			int result =productoService.registrarProducto(producto);
			atribute
			.addFlashAttribute("mensaje", "Se registró el producto correctamente ✔")
			.addFlashAttribute("clase", "success");
		
		} catch (Exception e) {
			LOG.info("ERROR" + e.getMessage());
		}

		return "redirect:/producto/form";
	}
	
	@PostMapping("/registrarentrada")
	public String registrarEntradaProducto(@Valid @ModelAttribute("Producto") Producto producto, 
			BindingResult errors, Model model, RedirectAttributes atribute) {
		
		if (errors.hasErrors()) {
			LOG.info("numero de errores: "+errors.getErrorCount());
			for (ObjectError oe : errors.getAllErrors()) {
				LOG.info("error "+oe.getCode()+" "+oe.getObjectName()+ oe.getDefaultMessage());
			}
			
			
			return "registrarProductos";
		}
		

		try {
			@SuppressWarnings("unused")
			int result =productoService.registrarProducto(producto);
		} catch (Exception e) {
			LOG.info("ERROR" + e.getMessage());
		}

		return "redirect:/entradaproducto/";
	}
	
	
	@GetMapping("/lista")
	public String listaProducto(Model model) {
		List<Producto> listaProductos;
		listaProductos= productoService.listarProducto();
		model.addAttribute("productos", listaProductos);
		model.addAttribute("producto", new Producto());
		return "gestionarProducto";
	}
	
	@GetMapping("/edit/{id}")
	public String editarProducto(Model model, @PathVariable("id") int idProducto) {
		
		List<Categoria> listaCategorias= null;
		List<Proveedor> listaProveedores=null;
		listaCategorias = categoriaService.listarCategoria();
		listaProveedores = proveedorService.listarProveedores();
		Producto producto = productoService.buscarProductoId(idProducto);
		producto.setProveedor(new Proveedor());
		ProductoProveedor proveedorEncontrado= productoService.buscarIdProveedor(idProducto);
		LOG.info("proveedorEncontrado  " + proveedorEncontrado.toString());
		LOG.info("Producto  " + producto);
		
		producto.getProveedor().setId(proveedorEncontrado.getIdProveedor());
		
		model.addAttribute("Producto", producto);
		model.addAttribute("listaCategorias",listaCategorias);
		model.addAttribute("listaProveedores", listaProveedores);
		return "registrarProductos_edit";
	}
	@PostMapping("/actualizar")
	public String actualizarProducto( @ModelAttribute("Producto") Producto producto, 
			BindingResult errors, Model model, RedirectAttributes redirectAttrs) {
		
		
		
		if (errors.hasErrors()) {
			
			for (ObjectError oe : errors.getAllErrors()) {
				LOG.info("error"+oe.getCode()+" "+oe.getObjectName()+oe.getDefaultMessage());
			}
			redirectAttrs
			.addFlashAttribute("mensaje", "Ocurrio un error al actualizar")
			.addFlashAttribute("clase", "warning");
			
			return ("redirect:/producto/lista");
		}
		
		LOG.info("PRODUCTO " + producto.toString());
		
		try {
			
			@SuppressWarnings("unused")
			int result =productoService.actualizarProducto(producto);
		} catch (Exception e) {
			LOG.info(e.getMessage());
		}

		return "redirect:/producto/lista";
	}
	
	@PostMapping("/buscar")
	public String buscarProducto(@ModelAttribute("producto") Producto producto, Model model, RedirectAttributes redirectAttrs) {
		List<Producto> productos = new ArrayList<Producto>();
		LOG.info("Producto " + producto);
		if(producto.getCodigoBarras().equals("")){
			return ("redirect:/producto/lista");
		}
		try {
			Producto productoEncontrado = productoService.buscarCodBarras(producto.getCodigoBarras());
			if (productoEncontrado == null) {
				redirectAttrs
				.addFlashAttribute("mensaje", "El producto con ese codigo no existe 🤷‍")
				.addFlashAttribute("clase", "warning");
				return ("redirect:/producto/lista");
			}
			productos.add(productoEncontrado);
		} catch (Exception e) {
			LOG.info(e.getMessage());
			redirectAttrs
			.addFlashAttribute("mensaje", "Ocurrio un error en la base de datos")
			.addFlashAttribute("clase", "warning");
			
		}
		
		model.addAttribute("productos", productos);
		
		return "gestionarProducto_buscar";
	}
	
}

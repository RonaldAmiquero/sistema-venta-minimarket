package edu.cientifica.minimarket.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.cientifica.minimarket.model.DetalleEntradaProducto;
import edu.cientifica.minimarket.model.DetalleVenta;
import edu.cientifica.minimarket.model.EntradaProducto;
import edu.cientifica.minimarket.model.Producto;
import edu.cientifica.minimarket.model.Proveedor;
import edu.cientifica.minimarket.model.Venta;
import edu.cientifica.minimarket.services.EntradaProductoService;
import edu.cientifica.minimarket.services.ProductoService;
import edu.cientifica.minimarket.services.ProveedorService;

@Controller
@RequestMapping("/entradaproducto")
public class EntradaProductoController {
	protected final Log LOG =  LogFactory.getLog(this.getClass());
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	EntradaProductoService entradaProductoService;
	
	@Autowired
	ProveedorService proveedorService;

	@GetMapping("/")
	public String interfazEntradaProducto(Model model, HttpServletRequest request) {
		
		List<Proveedor> proveedores = proveedorService.listarProveedores();
		EntradaProducto entradap=new EntradaProducto();
		entradap.setIdEproducto(entradaProductoService.asignarIdEp());
		
		model.addAttribute("producto", new Producto());
		model.addAttribute("detalleEP", new DetalleEntradaProducto());
		model.addAttribute("entradap", entradap);
		model.addAttribute("proveedores", proveedores);
				
		return "entradaProductos";
	}
	
	@PostMapping("/agregar")
	public String agregarProducto(@ModelAttribute("producto") Producto producto, @ModelAttribute("detalleEP") DetalleEntradaProducto detalleEP,
			Model model, HttpServletRequest request, RedirectAttributes redirectAttrs) {
		List<DetalleEntradaProducto> carrito = EntradaProducto.obtenerCarrito(request);
		
		Producto productoEncontrado=productoService.buscarCodBarras(producto.getCodigoBarras());
		EntradaProducto entradaProd = new EntradaProducto();
		entradaProd.setIdEproducto(entradaProductoService.asignarIdEp());
		carrito.add(new DetalleEntradaProducto(productoEncontrado, entradaProd, detalleEP.getCantidadIngresado(),
				detalleEP.getCostoUnitario(), detalleEP.getFechavNuevo()));

		EntradaProducto.guardarCarrito(carrito, request);
		
		return "redirect:/entradaproducto/";
	}
	
	@PostMapping("/buscar")
	public String buscarProducto(@ModelAttribute("producto") Producto producto, Model model) {
		Producto productoBuscadoPorCodigo = productoService.buscarCodBarras(producto.getCodigoBarras());
		
		List<Proveedor> proveedores = proveedorService.listarProveedores();
		EntradaProducto entradap = new EntradaProducto();
		entradap.setIdEproducto(entradaProductoService.asignarIdEp());
		
		model.addAttribute("productoe", productoBuscadoPorCodigo);
		model.addAttribute("detalleEP", new DetalleEntradaProducto());
		model.addAttribute("entradap", entradap);
		model.addAttribute("proveedores", proveedores);
		
		return "entradaProductos_buscar";
	}
	
	@PostMapping(value="/quitar/{indice}")
	public String quitarDelCarrito(@PathVariable("indice") int indice, HttpServletRequest request) {
		List<DetalleEntradaProducto> carrito = EntradaProducto.obtenerCarrito(request);
        if (carrito != null && carrito.size() > 0 && carrito.get(indice) != null) {
            carrito.remove(indice);
            EntradaProducto.guardarCarrito(carrito, request);
        }
        return "redirect:/entradaproducto/";
	}
	
}

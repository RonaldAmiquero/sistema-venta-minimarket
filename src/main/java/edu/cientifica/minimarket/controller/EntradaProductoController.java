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

import edu.cientifica.minimarket.model.Categoria;
import edu.cientifica.minimarket.model.DetalleEntradaProducto;
import edu.cientifica.minimarket.model.DetalleVenta;
import edu.cientifica.minimarket.model.Empleado;
import edu.cientifica.minimarket.model.EntradaProducto;
import edu.cientifica.minimarket.model.Producto;
import edu.cientifica.minimarket.model.Proveedor;
import edu.cientifica.minimarket.model.Venta;
import edu.cientifica.minimarket.services.CategoriaService;
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
	
	@Autowired
	CategoriaService categoriaService;

	@GetMapping("/")
	public String interfazEntradaProducto(Model model, HttpServletRequest request) {
		List<Categoria> listaCategorias = categoriaService.listarCategoria();
		List<Proveedor> proveedores = proveedorService.listarProveedores();
		EntradaProducto entradap=new EntradaProducto();
		entradap.setIdEproducto(entradaProductoService.asignarIdEp());
		
		Producto producto = new Producto();
		producto.setIdProducto(productoService.asignarId());
		
		model.addAttribute("producto", producto);
		model.addAttribute("detalleEP", new DetalleEntradaProducto());
		model.addAttribute("entradap", entradap);
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("listaCategorias",listaCategorias);
				
		return "entradaProductos";
	}
	
	@PostMapping("/agregar")
	public String agregarProducto(@ModelAttribute("producto") Producto producto, @ModelAttribute("detalleEP") DetalleEntradaProducto detalleEP,
			Model model, HttpServletRequest request, RedirectAttributes redirectAttrs) {
		
		LOG.info("productoAGREGAR: " + producto);
		LOG.info("DetalleEntradaProducto : " + detalleEP);
		List<DetalleEntradaProducto> carrito = EntradaProducto.obtenerCarrito(request);
		/*
		if(detalleEP.getProducto() == null) {
			redirectAttrs.addFlashAttribute("mensaje", "No ha registrado nigun producto 🤷")
			.addFlashAttribute("clase","warning");
			return "redirect:/entradaproducto/";
		}*/
		Producto productoEncontrado=productoService.buscarCodBarras(producto.getCodigoBarras());
		EntradaProducto entradaProd = new EntradaProducto();
		entradaProd.setIdEproducto(entradaProductoService.asignarIdEp());
		carrito.add(new DetalleEntradaProducto(productoEncontrado, entradaProd, detalleEP.getCantidadIngresado(),
				detalleEP.getCostoUnitario(), detalleEP.getFechavNuevo()));

		EntradaProducto.guardarCarrito(carrito, request);
		
		return "redirect:/entradaproducto/";
	}
	
	@PostMapping("/buscar")
	public String buscarProducto(@ModelAttribute("producto") Producto producto, Model model, RedirectAttributes redirectAttrs) {
		Producto productoBuscadoPorCodigo = productoService.buscarCodBarras(producto.getCodigoBarras());
		if(productoBuscadoPorCodigo == null) {
			redirectAttrs.addFlashAttribute("mensaje", "El producto con el codigo '" + producto.getCodigoBarras() + "' no existe 🤷")
			.addFlashAttribute("clase","warning");
			return "redirect:/entradaproducto/";
		}
		
		
		List<Categoria> listaCategorias = categoriaService.listarCategoria();
		List<Proveedor> proveedores = proveedorService.listarProveedores();
		EntradaProducto entradap = new EntradaProducto();
		entradap.setIdEproducto(entradaProductoService.asignarIdEp());
		
		producto.setIdProducto(productoService.asignarId());
		model.addAttribute("producto", producto);
		model.addAttribute("productoe", productoBuscadoPorCodigo);
		model.addAttribute("detalleEP", new DetalleEntradaProducto());
		model.addAttribute("entradap", entradap);
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("listaCategorias",listaCategorias);
		
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
	
	@PostMapping("/guardar")
	public String guardarEntradaProducto(@ModelAttribute("entradap") EntradaProducto entradap, 
			HttpServletRequest request, RedirectAttributes redirectAttrs) {
		List<DetalleEntradaProducto> carrito = EntradaProducto.obtenerCarrito(request);
        if (carrito == null || carrito.size() <= 0) {
            return "redirect:/entradaproducto/";
        }
        
        @SuppressWarnings("unused")
        int resultEntradaProd= entradaProductoService.guardarEntradaProducto(entradap);

        for (DetalleEntradaProducto detalleEP : carrito) {
 
        	Producto p = productoService.buscarProductoId(detalleEP.getProducto().getIdProducto());
            p.sumarExistencia(detalleEP.getCantidadIngresado());
            p.actualizarCostoUnitario(detalleEP.getCostoUnitario());
            p.actualizarFechaVencimiento(detalleEP.getFechavNuevo());
            // Lo guardamos con la existencia ya restada
            @SuppressWarnings("unused")
            int resultadoProd= productoService.actualizarProducto(p);
            @SuppressWarnings("unused")
            int resultIngreso= entradaProductoService.guardarDetalleEntradaProducto(detalleEP);
        }
        
        EntradaProducto.limpiarCarrito(request);
        redirectAttrs
                .addFlashAttribute("mensaje", "Se registro la entrada de productos correctamente ✔")
                .addFlashAttribute("clase", "success");
		
		return "redirect:/entradaproducto/";
	}
	
	
	
}

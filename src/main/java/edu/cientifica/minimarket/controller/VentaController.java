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

import edu.cientifica.minimarket.model.Cliente;
import edu.cientifica.minimarket.model.ComprobantePago;
import edu.cientifica.minimarket.model.DetalleVenta;
import edu.cientifica.minimarket.model.Producto;
import edu.cientifica.minimarket.model.TipoComprobante;
import edu.cientifica.minimarket.model.Venta;
import edu.cientifica.minimarket.services.ClienteService;
import edu.cientifica.minimarket.services.ComprobantePagoService;
import edu.cientifica.minimarket.services.ProductoService;
import edu.cientifica.minimarket.services.VentaService;
import edu.cientifica.minimarket.utilidades.FechasVenta;

@Controller
@RequestMapping("/venta")
public class VentaController {
	
	protected final Log LOG =  LogFactory.getLog(this.getClass());
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	VentaService ventaService;
	
	@Autowired
	ComprobantePagoService comprobanteService;
	
	@Autowired
	ClienteService clienteService;

	@GetMapping("/")
	public String interfazVenta(Model model, HttpServletRequest request) {
		model.addAttribute("producto", new Producto());
		ComprobantePago comprobante = new ComprobantePago();
		comprobante.setIdComprobanteP(comprobanteService.buscarIdComprobante());
		model.addAttribute("comprobante",comprobante);
		List<TipoComprobante> listaTipoComprobante = comprobanteService.listarTipoComprobante();
		List<Cliente> listaClientes= clienteService.listarClientes();
		float subTotal=0;
		List<DetalleVenta> carrito = Venta.obtenerCarrito(request);
		for (DetalleVenta d: carrito) {
			subTotal+= d.getImporte(); 
		}
		model.addAttribute("subTotal",subTotal);
		//model.addAttribute("carrito", carrito);
		model.addAttribute("listaTipoComprobante", listaTipoComprobante);
	    model.addAttribute("listaClientes", listaClientes);
	    
		return "realizarVenta";
	}
	
	@PostMapping("/agregar")
	public String agregarAlCarrito(@ModelAttribute("producto") Producto producto, HttpServletRequest request, RedirectAttributes redirectAttrs) {
		List<DetalleVenta> carrito = Venta.obtenerCarrito(request);
		Producto productoBuscadoPorCodigo = productoService.buscarCodBarras(producto.getCodigoBarras());
		if(productoBuscadoPorCodigo == null) {
			redirectAttrs.addFlashAttribute("mensaje", "El producto con el codigo '" + producto.getCodigoBarras() + "' no existe 🤷")
			.addFlashAttribute("clase","warning");
			return "redirect:/venta/";
		}
		
		if(productoBuscadoPorCodigo.sinExistencia()) {
			redirectAttrs
			.addFlashAttribute("mensaje", "el producto esta agotado 🤷‍♀️")
			.addFlashAttribute("clase", "warning");
			return "redirect:/venta/";
		}
		
		boolean encontrado=false;
		
		for (DetalleVenta detalleVenta : carrito) {
			if (detalleVenta.getProducto().getCodigoBarras().equals(productoBuscadoPorCodigo.getCodigoBarras())) {
				detalleVenta.aumentarCantidad();
				encontrado = true;
				break;
			} 
		}
		
		if(!encontrado) {
			Venta venta = new Venta();
			venta.setIdVenta(ventaService.asignarIdVenta());
			carrito.add(new DetalleVenta(productoBuscadoPorCodigo, venta ,1));
		}
		Venta.guardarCarrito(carrito, request);
		return "redirect:/venta/";
	}
	
	@PostMapping(value="/quitar/{indice}")
	public String quitarDelCarrito(@PathVariable("indice") int indice, HttpServletRequest request) {
		List<DetalleVenta> carrito = Venta.obtenerCarrito(request);
        if (carrito != null && carrito.size() > 0 && carrito.get(indice) != null) {
            carrito.remove(indice);
            Venta.guardarCarrito(carrito, request);
        }
        return "redirect:/venta/";
	}
	
	@GetMapping("/nuevaventa")
	public String nuevaVenta(HttpServletRequest request, RedirectAttributes redirectAttrs) {
		Venta.limpiarCarrito(request);
		redirectAttrs
		.addFlashAttribute("mensaje", "Se limpio el carrito correctamente 🛒")
		.addFlashAttribute("clase", "info");
		return "redirect:/venta/";
	}
	
	@GetMapping("/lista")
	public String listarVenta(Model model) {
		List<Venta> ventas = ventaService.listarVentas();
		model.addAttribute("ventas", ventas);
		model.addAttribute("fecha", new FechasVenta());
		return "ventasRegistradas";
	}
	
	@PostMapping("/buscar")
	public String buscarVentas(@ModelAttribute("fecha") FechasVenta fechaVenta, Model model, RedirectAttributes redirectAttrs) {
		LOG.info("Fechas:  " + fechaVenta);
		if(fechaVenta.getFechaInicio()==null){
			redirectAttrs
			.addFlashAttribute("mensaje", "Tienes que seleccionar el rango de fechas")
			.addFlashAttribute("clase", "info");
			return "redirect:/venta/lista";
		}
		List<Venta> ventas = ventaService.buscarVenta(fechaVenta.getFechaInicio(),fechaVenta.getFechaFin());
		LOG.info("fecha:  "+ fechaVenta.getFechaInicio());
		LOG.info("ventas:  " + ventas);
		model.addAttribute("ventas", ventas);
		return "ventasRegistradas_buscar";
	}
	
	
	
}

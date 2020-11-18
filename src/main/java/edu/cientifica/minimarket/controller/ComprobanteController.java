package edu.cientifica.minimarket.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.cientifica.minimarket.model.ComprobantePago;
import edu.cientifica.minimarket.model.DetalleVenta;
import edu.cientifica.minimarket.model.Empleado;
import edu.cientifica.minimarket.model.Producto;
import edu.cientifica.minimarket.model.Venta;
import edu.cientifica.minimarket.services.ComprobantePagoService;
import edu.cientifica.minimarket.services.ProductoService;
import edu.cientifica.minimarket.services.VentaService;

@Controller
@RequestMapping("/comprobante")
public class ComprobanteController {
	@Autowired
	ProductoService productoService;
	
	@Autowired
	VentaService ventaService;
	
	@Autowired
	ComprobantePagoService comprobanteService;
	
	@PostMapping("/registrar")
	public String registrarVenta(@ModelAttribute("comprobante") ComprobantePago comprobante, HttpServletRequest request, RedirectAttributes redirectAttrs) {
		List<DetalleVenta> carrito = Venta.obtenerCarrito(request);
        if (carrito == null || carrito.size() <= 0) {
            return "redirect:/venta/";
        }
        
        @SuppressWarnings("unused")
		int resultVenta= ventaService.guardarVenta(new Venta(ventaService.asignarIdVenta(), comprobante.getFecha(), comprobante.getCliente(), new Empleado(3),comprobante.getTipoComprobante()));

        for (DetalleVenta detalleV : carrito) {
 
        	Producto p = productoService.buscarProductoId(detalleV.getProducto().getIdProducto());
            p.restarExistencia(detalleV.getCantidad());
            // Lo guardamos con la existencia ya restada
            @SuppressWarnings("unused")
            int resultadoProd= productoService.actualizarProducto(p);
            @SuppressWarnings("unused")
            int resultIngreso= ventaService.registrarDetalleVenta(detalleV);
        }
        
        @SuppressWarnings("unused")
        int resultComprobante= comprobanteService.guardarComprobante(comprobante);
        
        Venta.limpiarCarrito(request);
        // e indicamos una venta exitosa
        redirectAttrs
                .addFlashAttribute("mensaje", "Venta realizada correctamente")
                .addFlashAttribute("clase", "success");
		return "redirect:/venta/";
	}
	
}

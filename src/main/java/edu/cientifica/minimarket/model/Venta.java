package edu.cientifica.minimarket.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Venta {
	private int idVenta;
	private Cliente cliente;
	private Empleado empleado;
	private ComprobantePago comprobantePago;

	
	public Venta() {
		super();

	}
	
	public Venta(int idVenta) {
		super();
		this.idVenta = idVenta;
	}



	public Venta(int idVenta, Cliente cliente, Empleado empleado, ComprobantePago comprobantePago) {
		super();
		this.idVenta = idVenta;
		this.cliente = cliente;
		this.empleado = empleado;
		this.comprobantePago = comprobantePago;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public ComprobantePago getComprobantePago() {
		return comprobantePago;
	}

	public void setComprobantePago(ComprobantePago comprobantePago) {
		this.comprobantePago = comprobantePago;
	}

	public static void guardarCarrito(List<DetalleVenta> carrito, HttpServletRequest request) {
		request.getSession().setAttribute("carrito", carrito);
	}
	
	public static List<DetalleVenta> obtenerCarrito(HttpServletRequest request){
		//Es una anotación para suprimir las advertencias de compilación sobre operaciones genéricas no verificadas (no excepciones),
		@SuppressWarnings("unchecked")
		List<DetalleVenta> carrito = (List<DetalleVenta>) request.getSession().getAttribute("carrito");
		if (carrito == null) {
            carrito = new ArrayList<DetalleVenta>();
        }
		return carrito;
	}
	
	public static void limpiarCarrito(HttpServletRequest request) {
		guardarCarrito(new ArrayList<DetalleVenta>(), request);
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", cliente=" + cliente + ", empleado=" + empleado + ", comprobantePago="
				+ comprobantePago + "]";
	}



}

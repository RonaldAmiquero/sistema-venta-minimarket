package edu.cientifica.minimarket.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Venta {
	private int idVenta;
	private Date fecha;
	private Cliente cliente;
	private Empleado empleado;
	private TipoComprobante tipoComprobante;

	
	public Venta() {
		super();

	}
	
	public Venta(int idVenta) {
		super();
		this.idVenta = idVenta;
	}



	public Venta(int idVenta, Date fecha, Cliente cliente, Empleado empleado, TipoComprobante tipoComprobante) {
		super();
		this.idVenta = idVenta;
		this.fecha = fecha;
		this.cliente = cliente;
		this.empleado = empleado;
		this.tipoComprobante = tipoComprobante;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public TipoComprobante getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(TipoComprobante tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
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

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", fecha=" + fecha + ", cliente=" + cliente + ", empleado=" + empleado
				+ ", tipoComprobante=" + tipoComprobante + "]";
	}
	

}

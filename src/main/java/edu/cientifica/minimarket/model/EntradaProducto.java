package edu.cientifica.minimarket.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class EntradaProducto {
	
	private int idEproducto;
	private String nroFactura;
	private Date fechaIngreso;
	private Proveedor proveedor;
	
	
	public EntradaProducto() {
		super();
	}


	public EntradaProducto(int idEproducto, String nroFactura, Date fechaIngreso, Proveedor proveedor) {
		super();
		this.idEproducto = idEproducto;
		this.nroFactura = nroFactura;
		this.fechaIngreso = fechaIngreso;
		this.proveedor = proveedor;
	}


	public EntradaProducto(int idEproducto) {
		super();
		this.idEproducto = idEproducto;
	}


	public int getIdEproducto() {
		return idEproducto;
	}


	public void setIdEproducto(int idEproducto) {
		this.idEproducto = idEproducto;
	}


	public String getNroFactura() {
		return nroFactura;
	}


	public void setNroFactura(String nroFactura) {
		this.nroFactura = nroFactura;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	public static void guardarCarrito(List<DetalleEntradaProducto> carrito, HttpServletRequest request) {
		request.getSession().setAttribute("carritoep", carrito);
	}
	
	public static List<DetalleEntradaProducto> obtenerCarrito(HttpServletRequest request){
		//Es una anotación para suprimir las advertencias de compilación sobre operaciones genéricas no verificadas (no excepciones),
		@SuppressWarnings("unchecked")
		List<DetalleEntradaProducto> carrito = (List<DetalleEntradaProducto>) request.getSession().getAttribute("carritoep");
		if (carrito == null) {
            carrito = new ArrayList<DetalleEntradaProducto>();
        }
		return carrito;
	}


	@Override
	public String toString() {
		return "EntradaProducto [idEproducto=" + idEproducto + ", nroFactura=" + nroFactura + ", fechaIngreso="
				+ fechaIngreso + ", proveedor=" + proveedor + "]";
	}

	
	

}

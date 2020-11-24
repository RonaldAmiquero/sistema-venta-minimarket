package edu.cientifica.minimarket.model;

import java.sql.Date;

public class DetalleEntradaProducto {
	
	private Producto producto;
	private EntradaProducto entradaProducto;
	private int cantidadIngresado;
	private double costoUnitario;
	private Date fechavNuevo;
	
	public DetalleEntradaProducto() {
		super();
	}

	public DetalleEntradaProducto(Producto producto, EntradaProducto entradaProducto, int cantidadIngresado,
			double costoUnitario, Date fechavNuevo) {
		super();
		this.producto = producto;
		this.entradaProducto = entradaProducto;
		this.cantidadIngresado = cantidadIngresado;
		this.costoUnitario = costoUnitario;
		this.fechavNuevo = fechavNuevo;
	}

	@Override
	public String toString() {
		return "DetalleEntradaProducto [producto=" + producto + ", entradaProducto=" + entradaProducto
				+ ", cantidadIngresado=" + cantidadIngresado + ", costoUnitario=" + costoUnitario + ", fechavNuevo="
				+ fechavNuevo + "]";
	}
	

}

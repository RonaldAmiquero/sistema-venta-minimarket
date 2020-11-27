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
	
	

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public EntradaProducto getEntradaProducto() {
		return entradaProducto;
	}

	public void setEntradaProducto(EntradaProducto entradaProducto) {
		this.entradaProducto = entradaProducto;
	}

	public int getCantidadIngresado() {
		return cantidadIngresado;
	}

	public void setCantidadIngresado(int cantidadIngresado) {
		this.cantidadIngresado = cantidadIngresado;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public Date getFechavNuevo() {
		return fechavNuevo;
	}

	public void setFechavNuevo(Date fechavNuevo) {
		this.fechavNuevo = fechavNuevo;
	}
	

	@Override
	public String toString() {
		return "DetalleEntradaProducto [producto=" + producto + ", entradaProducto=" + entradaProducto
				+ ", cantidadIngresado=" + cantidadIngresado + ", costoUnitario=" + costoUnitario + ", fechavNuevo="
				+ fechavNuevo + "]";
	}
	

}

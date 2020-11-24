package edu.cientifica.minimarket.model;

import java.sql.Date;

public class EntradaProducto {
	
	private int idEproducto;
	private int nroFactura;
	private Date fechaIngreso;
	private Empleado empleado;
	
	
	public EntradaProducto() {
		super();
	}


	public EntradaProducto(int idEproducto, int nroFactura, Date fechaIngreso, Empleado empleado) {
		super();
		this.idEproducto = idEproducto;
		this.nroFactura = nroFactura;
		this.fechaIngreso = fechaIngreso;
		this.empleado = empleado;
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


	public int getNroFactura() {
		return nroFactura;
	}


	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	@Override
	public String toString() {
		return "EntradaProducto [idEproducto=" + idEproducto + ", nroFactura=" + nroFactura + ", fechaIngreso="
				+ fechaIngreso + ", empleado=" + empleado + "]";
	}
	
	

}

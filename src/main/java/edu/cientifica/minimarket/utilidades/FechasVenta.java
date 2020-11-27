package edu.cientifica.minimarket.utilidades;

import java.sql.Date;

public class FechasVenta {
	private Date fechaInicio;
	private Date fechaFin;
	
	public FechasVenta() {
		super();
	}

	public FechasVenta(Date fechaInicio, Date fechaFin) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "FechasVenta [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}

	
}

package edu.cientifica.minimarket.model;

import java.sql.Date;

public class ComprobantePago {
	
	private int idComprobanteP;
	private Date fecha;
	private double subTotal;
	private double igv;
	private double totalVenta;
	private String metodoPago;
	private TipoComprobante tipoComprobante;
	private Cliente cliente;
	
	public ComprobantePago() {
		super();
	}

	public ComprobantePago(int idComprobanteP, Date fecha, double subTotal, double igv, double totalVenta,
			String metodoPago, TipoComprobante tipoComprobante, Cliente cliente) {
		super();
		this.idComprobanteP = idComprobanteP;
		this.fecha = fecha;
		this.subTotal = subTotal;
		this.igv = igv;
		this.totalVenta = totalVenta;
		this.metodoPago = metodoPago;
		this.tipoComprobante = tipoComprobante;
		this.cliente = cliente;
	}
	
	public ComprobantePago(int idComprobanteP, Date fecha, double subTotal, double igv, double totalVenta,
			String metodoPago, TipoComprobante tipoComprobante) {
		super();
		this.idComprobanteP = idComprobanteP;
		this.fecha = fecha;
		this.subTotal = subTotal;
		this.igv = igv;
		this.totalVenta = totalVenta;
		this.metodoPago = metodoPago;
		this.tipoComprobante = tipoComprobante;
	}

	public int getIdComprobanteP() {
		return idComprobanteP;
	}

	public void setIdComprobanteP(int idComprobanteP) {
		this.idComprobanteP = idComprobanteP;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public TipoComprobante getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(TipoComprobante tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "ComprobantePago [idComprobanteP=" + idComprobanteP + ", fecha=" + fecha + ", subTotal=" + subTotal
				+ ", igv=" + igv + ", totalVenta=" + totalVenta + ", metodoPago=" + metodoPago + ", tipoComprobante="
				+ tipoComprobante + ", cliente=" + cliente + "]";
	}	

}

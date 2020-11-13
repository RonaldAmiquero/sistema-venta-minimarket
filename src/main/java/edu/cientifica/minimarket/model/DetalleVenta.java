package edu.cientifica.minimarket.model;

public class DetalleVenta {
	
	private Producto producto;
	private Venta venta;
	private int cantidad;
	private double importe;
	
	
	public DetalleVenta() {
		super();
	}


	public DetalleVenta(Producto producto, Venta venta, int cantidad, double importe) {
		super();
		this.producto = producto;
		this.venta = venta;
		this.cantidad = cantidad;
		this.importe = importe;
	}
	
	public DetalleVenta(Producto producto, Venta venta, int cantidad) {
		super();
		this.producto = producto;
		this.venta = venta;
		this.cantidad = cantidad;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public Venta getVenta() {
		return venta;
	}


	public void setVenta(Venta venta) {
		this.venta = venta;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getImporte() {
		double importe= this.cantidad * this.producto.getPrecioVenta();
		return importe;
	}


	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	public void aumentarCantidad() {
		this.cantidad++;	
	}


	@Override
	public String toString() {
		return "DetalleVenta [producto=" + producto + ", venta=" + venta + ", cantidad=" + cantidad + ", importe="
				+ importe + "]";
	}


	
	
}

package edu.cientifica.minimarket.model;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Producto {
	
	private int idProducto;
	
	@NotEmpty(message="Debes especificar el codigo de barras")
	private String codigoBarras;
	
	@NotEmpty(message="Debes especificar el nombre del producto")
	private String nombre;
	
	@NotNull(message="Debes especificar la categoria")
	private Categoria categoria;
	
	@NotNull
	private double costoUnitario;
	
	@NotNull
	private double precioVenta;
	
	@NotNull
	private int stockProducto;
	
	@NotNull(message="La fecha de vencimiento del producto es requerido")
	private Date fechaVencimiento;
	
	@NotNull
	private Proveedor proveedor;

	public Producto() {
		super();
	}

	public Producto(Producto producto) {
		super();
		this.idProducto = producto.idProducto;
		this.codigoBarras = producto.codigoBarras;
		this.nombre = producto.nombre;
		this.categoria = producto.categoria;
		this.costoUnitario = producto.costoUnitario;
		this.precioVenta = producto.precioVenta;
		this.stockProducto = producto.stockProducto;
		this.fechaVencimiento = producto.fechaVencimiento;
		this.proveedor = producto.proveedor;
	}

	public Producto(int idProducto, String codigoBarras, String nombre, Categoria categoria, double costoUnitario,
			double precioVenta, int stockProducto, Date fechaVencimiento, Proveedor proveedor) {
		super();
		this.idProducto = idProducto;
		this.codigoBarras = codigoBarras;
		this.nombre = nombre;
		this.categoria = categoria;
		this.costoUnitario = costoUnitario;
		this.precioVenta = precioVenta;
		this.stockProducto = stockProducto;
		this.fechaVencimiento = fechaVencimiento;
		this.proveedor = proveedor;
	}

	public Producto(int idProducto, String codigoBarras, String nombre, Categoria categoria, double costoUnitario,
			double precioVenta, int stockProducto, Date fechaVencimiento) {
		super();
		this.idProducto = idProducto;
		this.codigoBarras = codigoBarras;
		this.nombre = nombre;
		this.categoria = categoria;
		this.costoUnitario = costoUnitario;
		this.precioVenta = precioVenta;
		this.stockProducto = stockProducto;
		this.fechaVencimiento = fechaVencimiento;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getStockProducto() {
		return stockProducto;
	}

	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public boolean sinExistencia() {
		return this.stockProducto <= 0;
	}
	
	public void restarExistencia(int cantidad) {
		this.stockProducto -= cantidad;
	}
	
	public void sumarExistencia(int cantidadIngresado) {
		this.stockProducto += cantidadIngresado;
		
	}

	public void actualizarFechaVencimiento(Date fechavNuevo) {
		this.fechaVencimiento = fechavNuevo;
		
	}
	
	public void actualizarCostoUnitario(double costoUnitarioNuevo) {
		this.costoUnitario = (costoUnitario+costoUnitarioNuevo)/2;
		
	}
	
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", codigoBarras=" + codigoBarras + ", nombre=" + nombre
				+ ", categoria=" + categoria + ", costoUnitario=" + costoUnitario + ", precioVenta=" + precioVenta
				+ ", stockProducto=" + stockProducto + ", fechaVencimiento=" + fechaVencimiento + ", proveedor="
				+ proveedor + "]";
	}



	

}

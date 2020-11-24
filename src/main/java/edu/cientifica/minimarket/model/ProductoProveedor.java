package edu.cientifica.minimarket.model;

public class ProductoProveedor {
	
	private int idProducto;
	private int idProveedor;
	
	public ProductoProveedor() {
		super();
	}

	public ProductoProveedor(int idProducto, int idProveedor) {
		super();
		this.idProducto = idProducto;
		this.idProveedor = idProveedor;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	@Override
	public String toString() {
		return "ProductoProveedor [idProducto=" + idProducto + ", idProveedor=" + idProveedor + "]";
	}
	
	
	
	
	

}

package edu.cientifica.minimarket.model;

public class ProductoProveedore {
	
	private Producto producto;
	private Proveedor proveedor;
	
	public ProductoProveedore() {
		super();
	}

	public ProductoProveedore(Producto producto, Proveedor proveedor) {
		super();
		this.producto = producto;
		this.proveedor = proveedor;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "ProductoProveedore [producto=" + producto + ", proveedor=" + proveedor + "]";
	}

	
}

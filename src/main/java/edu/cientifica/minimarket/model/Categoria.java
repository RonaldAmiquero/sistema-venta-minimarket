package edu.cientifica.minimarket.model;

public class Categoria {
	private int idCategoria;
	private String descripcion;
	private int stockMinimo;
	private String estado;
	public Categoria() {
		super();
	}


	public Categoria(int idCategoria, String descripcion, int stockMinimo, String estado) {
		super();
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
		this.stockMinimo = stockMinimo;
		this.estado = estado;
	}


	public Categoria(int idCategoria, String descripcion) {
		super();
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
	}


	public int getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getStockMinimo() {
		return stockMinimo;
	}


	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", descripcion=" + descripcion + ", stockMinimo=" + stockMinimo
				+ ", estado=" + estado + "]";
	}
	

}

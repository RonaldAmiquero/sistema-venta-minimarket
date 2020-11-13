package edu.cientifica.minimarket.model;

public class TipoComprobante {
	
	private int idTipoC;
	private String descripcion;
	
	public TipoComprobante() {
		super();
	}

	public TipoComprobante(int idTipoC, String descripcion) {
		super();
		this.idTipoC = idTipoC;
		this.descripcion = descripcion;
	}

	public int getIdTipoC() {
		return idTipoC;
	}

	public void setIdTipoC(int idTipoC) {
		this.idTipoC = idTipoC;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoComprobante [idTipoC=" + idTipoC + ", descripcion=" + descripcion + "]";
	}
	
	

}

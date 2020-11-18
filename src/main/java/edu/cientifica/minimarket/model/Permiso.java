package edu.cientifica.minimarket.model;

public class Permiso {
	
	private int idPermiso;
	private String descripcion;
	
	
	public Permiso() {
		super();
	}


	public Permiso(int idPermiso, String descripcion) {
		super();
		this.idPermiso = idPermiso;
		this.descripcion = descripcion;
	}


	public int getIdPermiso() {
		return idPermiso;
	}


	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return "Permiso [idPermiso=" + idPermiso + ", descripcion=" + descripcion + "]";
	}
	
	
}

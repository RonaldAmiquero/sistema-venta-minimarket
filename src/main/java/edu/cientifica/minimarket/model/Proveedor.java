package edu.cientifica.minimarket.model;

public class Proveedor extends Persona{
	private int ruc;
	private String nombreEmpresa;
	private String comercializa;
	
	public Proveedor() {}
	
	public Proveedor(int id, String nombreRepresentante, String email, int telefono, String direccion, int ruc, String nombreEmpresa,
			String comercializa) {
		super(id, nombreRepresentante, email, telefono, direccion);
		this.ruc = ruc;
		this.nombreEmpresa = nombreEmpresa;
		this.comercializa = comercializa;
	}
	
	public Proveedor(Persona persona) {
		super(persona.getId(),persona.getNombre(),persona.getEmail(),persona.getTelefono(),persona.getDireccion());	
	}

	public Proveedor(int id, String nombreRepresentante, String email, int telefono, String direccion, int ruc,
			String nombreEmpresa) {
		super(id, nombreRepresentante, email, telefono, direccion);
		this.ruc = ruc;
		this.nombreEmpresa = nombreEmpresa;
	}
	
	public Proveedor(int id, String nombreRepresentante, String email, int telefono, int ruc, String nombreEmpresa,
			String comercializa) {
		super(id, nombreRepresentante, email, telefono);
		this.ruc = ruc;
		this.nombreEmpresa = nombreEmpresa;
		this.comercializa = comercializa;
	}
	
	public Proveedor(int id, String nombreRepresentante, String email, int telefono, int ruc, String nombreEmpresa) {
		super(id, nombreRepresentante, email, telefono);
		this.ruc = ruc;
		this.nombreEmpresa = nombreEmpresa;
	}

	public int getRuc() {
		return ruc;
	}

	public void setRuc(int ruc) {
		this.ruc = ruc;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getComercializa() {
		return comercializa;
	}

	public void setComercializa(String comercializa) {
		this.comercializa = comercializa;
	}
	
}

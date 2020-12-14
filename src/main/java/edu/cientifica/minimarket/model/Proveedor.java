package edu.cientifica.minimarket.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Proveedor extends Persona{
	@NotNull
	private int ruc;
	@NotNull
	@Size(min=3, max=50)
	private String nombreEmpresa;
	@NotNull
	private String comercializa;
	
	public Proveedor() {}
	
	public Proveedor(@NotNull int id, @NotNull @Size(min=3, max=50) String nombreRepresentante, String email, int telefono, String direccion, int ruc, String nombreEmpresa,
			@NotNull String comercializa) {
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

	@Override
	public String toString() {
		return "Proveedor ["+ super.toString() + ", ruc=" + ruc + ", nombreEmpresa=" + nombreEmpresa + ", comercializa=" + comercializa + "]";
	}

	
	
	
}

package edu.cientifica.minimarket.model;

public class Cliente extends Persona{
	
	private int dniCliente;

	public Cliente() {
		super();
	}

	public Cliente(int id, String nombre, String email, int telefono, String direccion, int dni) {
		super(id, nombre, email, telefono, direccion);
		this.dniCliente = dni;
	}

	public Cliente(int id, String nombre, int dni) {
		super(id, nombre);
		this.dniCliente = dni;
	}

	public Cliente(int id, String nombre, String direccion) {
		super(id, nombre, direccion);
	}

	public Cliente(Persona persona) {
		super(persona);
	}

	public int getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(int dniCliente) {
		this.dniCliente = dniCliente;
	}

	@Override
	public String toString() {
		return "Cliente ["+ super.toString() + ", dniCliente=" + dniCliente + "]";
	}

	

	
	
}

package edu.cientifica.minimarket.model;

public class Empleado extends Persona{
	private int dni;
	private String apellido;
	private String genero;
	
	public Empleado() {
		super();
	}

	public Empleado(int id, String nombre, String email, int telefono, String direccion, int dni, String apellido,
			String genero) {
		super(id, nombre, email, telefono, direccion);
		this.dni = dni;
		this.apellido = apellido;
		this.genero = genero;
	}

	public Empleado(int id, String nombre, String email, int telefono, String direccion, int dni) {
		super(id, nombre, email, telefono, direccion);
		this.dni = dni;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Empleado ["+ super.toString() + ", dni=" + dni + ", apellido=" + apellido + ", genero=" + genero + "]";
	}
	
	
	

}

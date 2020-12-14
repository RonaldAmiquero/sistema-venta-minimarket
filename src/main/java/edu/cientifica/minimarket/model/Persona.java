package edu.cientifica.minimarket.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Persona {
	@NotNull
	private int id;
	@NotNull (message="Debes especificar el nombre")
	@Size(min=3, max=50, message="El nombre debe medir entre 3 y 50")
	private String nombre;
	@NotNull
	private String email;
	@NotNull
	private int telefono;
	@NotNull
	private String direccion;
	
	public Persona() {
		super();
	}

	public Persona(@NotNull int id,@NotNull @Size(min=3, max=50) String nombre, @NotNull String email, 
			@NotNull int telefono, @NotNull  String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	public Persona(int id, String nombre, String email, int telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}
	
	public Persona(Persona persona) {
		super();
		this.id = persona.id;
		this.nombre = persona.nombre;
		this.email = persona.email;
		this.telefono = persona.telefono;
		this.direccion = persona.direccion;
	}

	public Persona(int id, String nombre, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public Persona(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Persona(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
				+ ", direccion=" + direccion + "]";
	}
	
	
}

package edu.cientifica.minimarket.model;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CuentaUsuario{
	@NotNull
	private int idCuenta;
	
	@NotNull
	@Size(min=5, message = "El usuario debe ser mayor a 5 digitos")
	private String usuario;
	
	@NotNull
	@Size(min = 5, message = "La contraseña debe ser mayor a 5 digitos")
	private String contrasenha;
	

	private String tipoUsuario;
	
	private Empleado empleado;
	
	private Permiso permisos;
	
	
	public CuentaUsuario() {
		super();
	}



	public CuentaUsuario(@NotNull int idCuenta, 
			@NotNull @Size(min=5, max=10 , message = "El usuario debe tener de 5 a 10 caracteres") String usuario, 
	        @NotNull @Size(min = 5, max = 10, message = "La contraseña debe ser de cinco digitos")String contrasenha, 
	       String tipoUsuario, Empleado empleado,  Permiso permisos) {
		super();
		this.idCuenta = idCuenta;
		this.usuario = usuario;
		this.contrasenha = contrasenha;
		this.tipoUsuario = tipoUsuario;
		this.empleado = empleado;
		this.permisos = permisos;
	}


	public CuentaUsuario(String usuario, String contrasenha) {
		super();
		this.usuario = usuario;
		this.contrasenha = contrasenha;
	}

	public CuentaUsuario(@NotNull int idCuenta, 
			@NotNull @Size(min=5, max=10 , message = "El usuario debe tener de 5 a 10 caracteres") String usuario, 
			@NotNull @Size(min = 5, max = 10, message = "La contraseña debe ser de cinco digitos") String contrasenha, 
			String tipoUsuario, Empleado empleado) {
		super();
		this.idCuenta = idCuenta;
		this.usuario = usuario;
		this.contrasenha = contrasenha;
		this.tipoUsuario = tipoUsuario;
		this.empleado = empleado;
	}


	public CuentaUsuario(int idCuenta) {
		super();
		this.idCuenta = idCuenta;
	}


	public int getIdCuenta() {
		return idCuenta;
	}


	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContrasenha() {
		return contrasenha;
	}


	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}


	public String getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}



	public Permiso getPermisos() {
		return permisos;
	}


	public void setPermisos(Permiso permisos) {
		this.permisos = permisos;
	}


	@Override
	public String toString() {
		return "CuentaUsuario [idCuenta=" + idCuenta + ", usuario=" + usuario + ", contrasenha=" + contrasenha
				+ ", tipoUsuario=" + tipoUsuario + ", empleado=" + empleado + ", permiso=" + permisos + "]";
	}
	

}

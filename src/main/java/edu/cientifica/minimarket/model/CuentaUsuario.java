package edu.cientifica.minimarket.model;

import java.util.List;

public class CuentaUsuario {
	
	private int idCuenta;
	private String usuario;
	private String contrasenha;
	private String tipoUsuario;
	private Empleado empleado;
	private List<Permiso> permisos;
	
	
	public CuentaUsuario() {
		super();
	}


	public CuentaUsuario(int idCuenta, String usuario, String contrasenha, String tipoUsuario, Empleado empleado,
			List<Permiso> permisos) {
		super();
		this.idCuenta = idCuenta;
		this.usuario = usuario;
		this.contrasenha = contrasenha;
		this.tipoUsuario = tipoUsuario;
		this.empleado = empleado;
		this.permisos = permisos;
	}

	public CuentaUsuario(int idCuenta, String usuario, String contrasenha, String tipoUsuario, Empleado empleado) {
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


	public List<Permiso> getPermisos() {
		return permisos;
	}


	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}


	@Override
	public String toString() {
		return "CuentaUsuario [idCuenta=" + idCuenta + ", usuario=" + usuario + ", contrasenha=" + contrasenha
				+ ", tipoUsuario=" + tipoUsuario + ", empleado=" + empleado + ", permisos=" + permisos + "]";
	}
	

}

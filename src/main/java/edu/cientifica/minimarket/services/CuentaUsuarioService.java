package edu.cientifica.minimarket.services;

import java.util.List;

import edu.cientifica.minimarket.model.CuentaUsuario;




public interface CuentaUsuarioService {
	public int registrarUsuario(CuentaUsuario usuario);
	public int completarId();
	public List<CuentaUsuario> listarUsuario();
	public int actualizarCuentaUsuario(CuentaUsuario usuario);
	public CuentaUsuario buscarCuentaUsuarioId(int idCuenta);
	public CuentaUsuario buscarEmpleadoId(int idCuenta);
	public CuentaUsuario buscarUsuario(String username); 
	public boolean validarUsuario(CuentaUsuario usuario);

}

package edu.cientifica.minimarket.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.CuentaUsuarioMapper;
import edu.cientifica.minimarket.model.CuentaUsuario;
import edu.cientifica.minimarket.services.CuentaUsuarioService;

@Service
public class CuentaUsuarioServiceImpl implements CuentaUsuarioService {
	
	
	/*
	public CuentaUsuarioServiceImpl() {
		super();
		listaUsuarios = new ArrayList<CuentaUsuario>();
		listaUsuarios.add(new CuentaUsuario("Juan", "clave"));
		listaUsuarios.add(new CuentaUsuario("Pedro", "clave"));
		listaUsuarios.add(new CuentaUsuario("Anita", "clave"));
	}
	*/
	
	protected final Log LOG = LogFactory.getLog(this.getClass());
	@Autowired
	CuentaUsuarioMapper usuarioMapper;

	@Override
	public int registrarUsuario(CuentaUsuario usuario) {

		return usuarioMapper.addUsuario(usuario);
	}

	@Override
	public int completarId() {
		return usuarioMapper.completarId();
	}

	@Override
	public List<CuentaUsuario> listarUsuario() {
		return usuarioMapper.findAllUsuarios();
	}

	@Override
	public int actualizarCuentaUsuario(CuentaUsuario usuario) {
		int result;
		result = usuarioMapper.updateCuentaUsuario(usuario);
		LOG.info("Numero de registros afectados : " + result);
		return result;
	}

	@Override
	public CuentaUsuario buscarCuentaUsuarioId(int idCuenta) {
		
		return usuarioMapper.findCuentaUsuarioId(idCuenta);
	}

	@Override
	public CuentaUsuario buscarEmpleadoId(int idCuenta) {
	
		return usuarioMapper.findIdCuentaUsuario(idCuenta);
	}
	
	
	
    private List<CuentaUsuario> listaUsuarios;
	
	@Override
	public CuentaUsuario buscarUsuario(String username) {
		for (CuentaUsuario usuario : listaUsuarios) {
			if (usuario.getUsuario().equals(username)) {
				return usuario;
			}
		}
		return null;
		
	}
	@Override
	public boolean validarUsuario(CuentaUsuario usuario) {
		for (CuentaUsuario user : listaUsuarios) {
			if (usuario.getUsuario().equals(user.getUsuario())) {
				if (usuario.getContrasenha().equals(user.getContrasenha())) {
					return true;
				} 
			}
		}		
		return false;
	}
	

}

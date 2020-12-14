package edu.cientifica.minimarket.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.CuentaUsuario_PermisoMapper;
import edu.cientifica.minimarket.model.CuentaUsuario;
import edu.cientifica.minimarket.services.CuentaUsuario_PermisoService;

@Service
public class CuentaUsuario_PermisoServiceImpl implements CuentaUsuario_PermisoService{
@Autowired CuentaUsuario_PermisoMapper cuentaUsuarioPermiso;
	@Override
	public int registrarCuentaPermiso(CuentaUsuario permiso) {
		return cuentaUsuarioPermiso.addPermiso(permiso);
	}
	@Override
	public int actualizarCuentaPermiso(CuentaUsuario permiso) {
		// TODO Auto-generated method stub
		return cuentaUsuarioPermiso.updateCuentaUsuarioPermiso(permiso);
	}

}

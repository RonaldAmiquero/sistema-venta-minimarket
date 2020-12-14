package edu.cientifica.minimarket.servicesimpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.PersonaMapper;
import edu.cientifica.minimarket.mappers.ProveedorMapper;
import edu.cientifica.minimarket.model.Proveedor;
import edu.cientifica.minimarket.services.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {
	protected final Log LOG = LogFactory.getLog(this.getClass());
	
	@Autowired
	ProveedorMapper proveedorMapper;
	
	
	@Override
	public List<Proveedor> listarProveedores() {
		return proveedorMapper.findAllProveedores();
	}

	@Override
	public int registrarProveedor(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return proveedorMapper.addProveedor(proveedor);
	}

	@Override
	public int asignarId() {
		return proveedorMapper.findId();
	}

	@Override
	public int actualizarProveedor(Proveedor proveedor) {
		int result;
		result = proveedorMapper.updateProveedor(proveedor);
		LOG.info("Numero de registros afectados : " + result);
		return result;
	}

	@Override
	public Proveedor buscarProveedorId(int id) {
		// TODO Auto-generated method stub
		return proveedorMapper.finProveedorId(id);
	}

	
}

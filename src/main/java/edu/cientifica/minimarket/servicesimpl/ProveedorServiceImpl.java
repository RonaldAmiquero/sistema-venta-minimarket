package edu.cientifica.minimarket.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.ProveedorMapper;
import edu.cientifica.minimarket.model.Proveedor;
import edu.cientifica.minimarket.services.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {
	
	@Autowired
	ProveedorMapper proveedorMapper;
	
	@Override
	public List<Proveedor> listarProveedores() {
		return proveedorMapper.findAllProveedores();
	}
}

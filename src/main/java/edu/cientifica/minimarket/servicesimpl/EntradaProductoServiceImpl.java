package edu.cientifica.minimarket.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.EntradaProductoMapper;
import edu.cientifica.minimarket.services.EntradaProductoService;

@Service
public class EntradaProductoServiceImpl implements EntradaProductoService{
	
	@Autowired
	EntradaProductoMapper entradaProductoMapper;
	
	@Override
	public int asignarIdEp() {
		
		return entradaProductoMapper.findIdEntradaProd();
	}

	
}

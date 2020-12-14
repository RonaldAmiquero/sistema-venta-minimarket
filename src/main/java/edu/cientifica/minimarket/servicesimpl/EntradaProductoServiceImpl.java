package edu.cientifica.minimarket.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.EntradaProductoMapper;
import edu.cientifica.minimarket.model.DetalleEntradaProducto;
import edu.cientifica.minimarket.model.EntradaProducto;
import edu.cientifica.minimarket.services.EntradaProductoService;

@Service
public class EntradaProductoServiceImpl implements EntradaProductoService{
	
	@Autowired
	EntradaProductoMapper entradaProductoMapper;
	
	@Override
	public int asignarIdEp() {
		
		return entradaProductoMapper.findIdEntradaProd();
	}

	@Override
	public int guardarEntradaProducto(EntradaProducto entradap) {
		return entradaProductoMapper.saveEntradaProducto(entradap);
	}

	@Override
	public int guardarDetalleEntradaProducto(DetalleEntradaProducto detalleEP) {
		// TODO Auto-generated method stub
		return entradaProductoMapper.saveDetalleEntradaProducto(detalleEP);
	}
	

}

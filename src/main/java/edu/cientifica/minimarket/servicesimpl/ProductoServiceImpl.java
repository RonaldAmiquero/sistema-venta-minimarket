package edu.cientifica.minimarket.servicesimpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.ProductoMapper;
import edu.cientifica.minimarket.model.Producto;
import edu.cientifica.minimarket.services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	protected final Log LOG = LogFactory.getLog(this.getClass());
	
	@Autowired
	ProductoMapper productoMapper;

	@Override
	public int registrarProducto(Producto producto) {
		int result = productoMapper.addProducto(producto);
		LOG.info("Numero de registros afectados : "+result);
		return result;
	}

	@Override
	public List<Producto> listarProducto() {
		return null;
	}

	@Override
	public int asignarId() {
		return productoMapper.findId();
	}
	
	

}

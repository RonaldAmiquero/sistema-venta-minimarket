package edu.cientifica.minimarket.servicesimpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.VentaMapper;
import edu.cientifica.minimarket.model.DetalleVenta;
import edu.cientifica.minimarket.model.Venta;
import edu.cientifica.minimarket.services.VentaService;

@Service
public class VentaServiceImpl implements VentaService{
	protected final Log LOG = LogFactory.getLog(this.getClass());
	
	@Autowired
	VentaMapper ventaMapper;

	@Override
	public int asignarIdVenta() {		
		return ventaMapper.findIdVenta();
	}

	@Override
	public int registrarDetalleVenta(DetalleVenta detalleVenta) {
		int result;
		result = ventaMapper.insertDetalleVenta(detalleVenta);
		LOG.info("Numero de registros afectados : " + result);
		return result;
	}

	@Override
	public int guardarVenta(Venta venta) {
		int result;
		result = ventaMapper.insertVenta(venta);
		LOG.info("Numero de registros afectados : " + result);
		return result;
	}
	
	

}

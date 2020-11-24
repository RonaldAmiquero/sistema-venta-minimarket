package edu.cientifica.minimarket.servicesimpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.ComprobantePagoMapper;
import edu.cientifica.minimarket.model.ComprobantePago;
import edu.cientifica.minimarket.model.TipoComprobante;
import edu.cientifica.minimarket.services.ComprobantePagoService;

@Service
public class ComprobantePagoServiceImpl implements ComprobantePagoService {
	protected final Log LOG = LogFactory.getLog(this.getClass());

	@Autowired
	ComprobantePagoMapper comprobantePagoMapper;
	
	@Override
	public List<TipoComprobante> listarTipoComprobante() {

		return comprobantePagoMapper.findAllTipoComprobante();
	}

	@Override
	public int buscarIdComprobante() {
		// TODO Auto-generated method stub
		return comprobantePagoMapper.findIdComprobante();
	}

	@Override
	public int guardarComprobante(ComprobantePago comprobante) {
		int result;
		result = comprobantePagoMapper.insertComprobante(comprobante);
		LOG.info("Numero de registros afectados : " + result);
		return result;
	}

	@Override
	public List<ComprobantePago> listarComprobante() {
		
		return comprobantePagoMapper.findAllComprobantePago();
	}

	

}

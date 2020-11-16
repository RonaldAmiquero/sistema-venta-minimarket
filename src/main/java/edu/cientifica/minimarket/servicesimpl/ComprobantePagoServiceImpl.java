package edu.cientifica.minimarket.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.ComprobantePagoMapper;
import edu.cientifica.minimarket.model.TipoComprobante;
import edu.cientifica.minimarket.services.ComprobantePagoService;

@Service
public class ComprobantePagoServiceImpl implements ComprobantePagoService {

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

	/*
	@Override
	public int buscarIdComprobante() {
		
		return comprobantePagoMapper.findIdComprobante();
	}
	
	*/
	

}

package edu.cientifica.minimarket.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.VentaMapper;
import edu.cientifica.minimarket.services.VentaService;

@Service
public class VentaServiceImpl implements VentaService{
	@Autowired
	VentaMapper ventaMapper;

	@Override
	public int asignarIdVenta() {		
		return ventaMapper.findIdVenta();
	}
	
	

}

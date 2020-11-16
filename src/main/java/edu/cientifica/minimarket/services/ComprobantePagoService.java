package edu.cientifica.minimarket.services;

import java.util.List;

import edu.cientifica.minimarket.model.TipoComprobante;

public interface ComprobantePagoService {
	
	public List<TipoComprobante> listarTipoComprobante();
	public int buscarIdComprobante();
	

}

package edu.cientifica.minimarket.services;

import edu.cientifica.minimarket.model.DetalleVenta;
import edu.cientifica.minimarket.model.Venta;

public interface VentaService {	
	
	public int asignarIdVenta();

	public int registrarDetalleVenta(DetalleVenta detalleVenta);

	public int guardarVenta(Venta venta);
	
}
